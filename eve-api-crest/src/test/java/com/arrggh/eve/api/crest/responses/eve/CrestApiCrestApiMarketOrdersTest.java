package com.arrggh.eve.api.crest.responses.eve;

import com.arrggh.eve.api.crest.responses.BasicResponseObjectValidation;

public class CrestApiCrestApiMarketOrdersTest extends BasicResponseObjectValidation<CrestApiMarketOrders> {

    @Override
    protected Class<CrestApiMarketOrders> getClassUnderTest() {
        return CrestApiMarketOrders.class;
    }

    @Override
    protected CrestApiMarketOrders getObjectUnderTest() {
        return CrestApiMarketOrders.builder().build();
    }
}