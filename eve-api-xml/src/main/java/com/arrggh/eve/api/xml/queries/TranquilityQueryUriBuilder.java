package com.arrggh.eve.api.xml.queries;

/**
 * A UriBuilder instances that targets the Production environment server (api.eveonline.com).
 */
public class TranquilityQueryUriBuilder extends QueryUriBuilder {
    @Override
    protected String getHostname() {
        return "api.eveonline.com";
    }
}