package com.arrggh.eve.api.crest;

import com.arrggh.eve.api.crest.parsers.CrestExpiryTimeCalculator;
import com.arrggh.eve.api.crest.parsers.ResponseParsers;
import com.arrggh.eve.api.crest.queries.QueryUriBuilder;
import com.arrggh.eve.api.crest.responses.eve.CrestApiMarketHistory;
import com.arrggh.eve.utilities.queries.CachedExternalQueryService;

import java.net.URI;
import java.time.Duration;

public class EveCrestApi {
    private final QueryUriBuilder queryUriBuilder;
    private final CachedExternalQueryService responseCache;

    private static final CrestExpiryTimeCalculator thirtyMinute = new CrestExpiryTimeCalculator(Duration.ofMinutes(30));

    public EveCrestApi(CachedExternalQueryService responseCache, QueryUriBuilder queryUriBuilder) {
        this.queryUriBuilder = queryUriBuilder;
        this.responseCache = responseCache;
    }

    public CrestApiMarketHistory getMarketHistory(long regionId, long typeId) {
        // "/market/10000002/history/?type=https://crest-tq.eveonline.com/inventory/types/34/"
        String path = "/market/" + regionId + "/history/?type=https://crest-tq.eveonline.com/inventory/types/" + typeId + "/";
        URI uri = queryUriBuilder.buildUrl(path);
        return responseCache.get(path, ResponseParsers::parseMarketHistory, thirtyMinute, uri).get();
    }
}
