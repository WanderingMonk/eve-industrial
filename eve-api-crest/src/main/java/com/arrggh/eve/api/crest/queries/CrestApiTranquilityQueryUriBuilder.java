package com.arrggh.eve.api.crest.queries;

/**
 * A UriBuilder instances that targets the Production environment server (crest-tq.eveonline.com).
 */
public class CrestApiTranquilityQueryUriBuilder extends QueryUriBuilder {
    @Override
    protected String getHostname() {
        return "crest-tq.eveonline.com";
    }
}