package com.arrggh.eve.api.crest.responses.eve;

import com.arrggh.eve.api.crest.responses.BasicResponseObjectValidation;
import com.arrggh.eve.api.crest.responses.eve.MarketOrder;

public class MarketOrderTest extends BasicResponseObjectValidation<MarketOrder> {

    @Override
    protected Class<MarketOrder> getClassUnderTest() {
        return MarketOrder.class;
    }

    @Override
    protected MarketOrder getObjectUnderTest() {
        return MarketOrder.builder().build();
    }
}