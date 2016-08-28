package com.arrggh.eve.api.crest.responses.eve;

import com.arrggh.eve.api.crest.responses.BasicResponseObjectValidation;

public class MarketHistoryTest extends BasicResponseObjectValidation<MarketHistory> {

    @Override
    protected Class<MarketHistory> getClassUnderTest() {
        return MarketHistory.class;
    }

    @Override
    protected MarketHistory getObjectUnderTest() {
        return MarketHistory.builder().build();
    }
}