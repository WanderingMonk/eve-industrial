package com.arrggh.eve.api.crest.responses.eve;

import com.arrggh.eve.api.crest.responses.BasicResponseObjectValidation;

public class MarketDayHistoryTest extends BasicResponseObjectValidation<MarketDayHistory> {

    @Override
    protected Class<MarketDayHistory> getClassUnderTest() {
        return MarketDayHistory.class;
    }

    @Override
    protected MarketDayHistory getObjectUnderTest() {
        return MarketDayHistory.builder().build();
    }
}