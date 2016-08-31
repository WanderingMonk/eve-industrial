package com.arrggh.eve.api.crest.responses.eve;

import com.arrggh.eve.api.crest.responses.BasicResponseObjectValidation;

public class CrestApiMarketDayHistoryTest extends BasicResponseObjectValidation<CrestApiMarketDayHistory> {

    @Override
    protected Class<CrestApiMarketDayHistory> getClassUnderTest() {
        return CrestApiMarketDayHistory.class;
    }

    @Override
    protected CrestApiMarketDayHistory getObjectUnderTest() {
        return CrestApiMarketDayHistory.builder().build();
    }
}