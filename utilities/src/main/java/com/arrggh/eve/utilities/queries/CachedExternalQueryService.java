package com.arrggh.eve.utilities.queries;

import com.arrggh.eve.utilities.exceptions.ParserException;
import com.arrggh.eve.utilities.cache.ICache;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.Optional;
import java.util.function.Function;

import static com.arrggh.eve.utilities.LanguageUtilities.isNotNull;
import static com.arrggh.eve.utilities.LanguageUtilities.not;

public class CachedExternalQueryService {
    private static final Logger LOG = LoggerFactory.getLogger(CachedExternalQueryService.class);

    private final ICache<CachedResponse> cache;

    public CachedExternalQueryService(ICache<CachedResponse> cache) {
        this.cache = cache;
    }

    public <T> Optional<T> get(String key, Function<String, T> parser, Function<String, Instant> expiryTimeCalculator, URI uri) {
        Optional<CachedResponse> cachedValue = getFromCache(key);

        // If the cache has a valid version of the file
        if (cachedValue.isPresent() && not(cachedValue.get().hasExpired())) {
            LOG.info("Using value from cache for key '{}'", key);
            return Optional.of(parser.apply(cachedValue.get().getDocument()));
        }

        // Try and get it from the API
        Optional<T> apiResult = getFromApi(key, parser, expiryTimeCalculator, uri);
        if (apiResult.isPresent()) {
            LOG.info("Using value fetched from API for key '{}'", key);
            return apiResult;
        }

        // Failback is return the cached version if exists
        if (cachedValue.isPresent()) {
            LOG.warn("API failed using old cached version for key '{}'", key);
            return Optional.of(parser.apply(cachedValue.get().getDocument()));
        }

        // Complete and utter failure, return empty
        LOG.warn("API failed and cache empty for key '{}'", key);
        return Optional.empty();
    }

    private Optional<CachedResponse> getFromCache(String key) {
        return cache.get(key);
    }

    private <T> Optional<T> getFromApi(String key, Function<String, T> parser, Function<String, Instant> expiryTimeCalculator, URI uri) {
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            HttpGet get = new HttpGet(uri);
            HttpResponse response = client.execute(get);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                String xml = EntityUtils.toString(response.getEntity());
                Instant expiry = expiryTimeCalculator.apply(xml);
                T object = parser.apply(xml);
                CachedResponse cachedResponse = CachedResponse.builder().expiryTime(expiry).document(xml).build();
                cache.put(key, Optional.of(cachedResponse));
                return Optional.of(object);
            } else {
                LOG.warn("API call returned with a non-Ok status code of {}", statusCode);
            }
        } catch (UnknownHostException e) {
            LOG.warn("Cannot connect to host, '{}'", uri.getHost());
        } catch (IOException e) {
            LOG.error("Problem executing get request '{}'", e, uri);
        } catch (ParserException e) {
            LOG.warn("Cannot parse response", e);
        } finally {
            if (isNotNull(client)) {
                try {
                    client.close();
                } catch (IOException e) {
                    LOG.warn("Cannot close client", e);
                }
            }
        }
        return Optional.empty();
    }
}