package com.arrggh.eve.api.crest.responses.eve;

import com.arrggh.eve.api.crest.responses.BasicResponseObjectValidation;

public class CrestApiMarketOrderTest extends BasicResponseObjectValidation<CrestApiMarketOrder> {

    @Override
    protected Class<CrestApiMarketOrder> getClassUnderTest() {
        return CrestApiMarketOrder.class;
    }

    @Override
    protected CrestApiMarketOrder getObjectUnderTest() {
        return CrestApiMarketOrder.builder().build();
    }
}