package com.arrggh.eve.api.crest.responses.eve;

import com.arrggh.eve.api.crest.responses.BasicResponseObjectValidation;

public class CrestApiMarketHistoryTest extends BasicResponseObjectValidation<CrestApiMarketHistory> {

    @Override
    protected Class<CrestApiMarketHistory> getClassUnderTest() {
        return CrestApiMarketHistory.class;
    }

    @Override
    protected CrestApiMarketHistory getObjectUnderTest() {
        return CrestApiMarketHistory.builder().build();
    }
}