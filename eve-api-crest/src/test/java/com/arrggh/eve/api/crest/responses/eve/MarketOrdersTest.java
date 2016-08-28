package com.arrggh.eve.api.crest.responses.eve;

import com.arrggh.eve.api.crest.responses.BasicResponseObjectValidation;
import com.arrggh.eve.api.crest.responses.eve.MarketOrders;

public class MarketOrdersTest extends BasicResponseObjectValidation<MarketOrders> {

    @Override
    protected Class<MarketOrders> getClassUnderTest() {
        return MarketOrders.class;
    }

    @Override
    protected MarketOrders getObjectUnderTest() {
        return MarketOrders.builder().build();
    }
}