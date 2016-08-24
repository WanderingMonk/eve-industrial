package com.arrggh.eve.api.xml.queries;

import com.arrggh.eve.api.xml.parsers.ParserException;
import com.arrggh.eve.utilities.cache.ICache;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.function.Function;

public class CachedExternalQueryService {
    private static final Logger LOG = LoggerFactory.getLogger(CachedExternalQueryService.class);

    private final ICache cache;
    private Function<String, Boolean> isValidChecker;

    public CachedExternalQueryService(ICache cache, Function<String, Boolean> isValidChecker) {
        this.cache = cache;
        this.isValidChecker = isValidChecker;
    }

    public <T> Optional<T> get(String key, Function<String, T> parser, URI uri) {
        Optional<String> cachedValue = getFromCache(key);

        // If the cache has a valid version of the file
        if (cachedValue.isPresent() && isValidChecker.apply(cachedValue.get())) {
            LOG.info("Using value from cache for key '{}'", key);
            return Optional.of(parser.apply(cachedValue.get()));
        }

        // Try and get it from the API
        Optional<T> apiResult = getFromApi(key, parser, uri);
        if (apiResult.isPresent()) {
            LOG.info("Using value fetched from API for key '{}'", key);
            return apiResult;
        }

        // Failback is return the cached version if exists
        if (cachedValue.isPresent()) {
            LOG.warn("API failed using old cached version for key '{}'", key);
            return Optional.of(parser.apply(cachedValue.get()));
        }

        // Complete and utter failure, return empty
        LOG.warn("API failed and cache empty for key '{}'", key);
        return Optional.empty();
    }

    private Optional<String> getFromCache(String key) {
        return cache.get(key);
    }

    private <T> Optional<T> getFromApi(String key, Function<String, T> parser, URI uri) {
        HttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(uri);
        try {
            HttpResponse response = client.execute(get);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                String xml = EntityUtils.toString(response.getEntity());
                cache.put(key, Optional.of(xml));
                return Optional.of(parser.apply(xml));
            } else {
                LOG.warn("API call returned with a non-Ok status code of {}", statusCode);
            }
        } catch (UnknownHostException e) {
            LOG.warn("Cannot connect to host, '{}'", uri.getHost());
        } catch (IOException e) {
            LOG.error("Problem executing get request '{}'", e, uri);
        } catch (ParserException e) {
            LOG.warn("Cannot parse response, '{}'", e);
        }
        return Optional.empty();
    }
}