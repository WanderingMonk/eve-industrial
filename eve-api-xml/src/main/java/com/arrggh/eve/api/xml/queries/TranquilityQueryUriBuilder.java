package com.arrggh.eve.api.xml.queries;

import com.arrggh.eve.utilities.queries.QueryUriBuilder;

/**
 * A UriBuilder instances that targets the Production environment server (api.eveonline.com).
 */
public class TranquilityQueryUriBuilder extends QueryUriBuilder {
    @Override
    protected String getHostname() {
        return "api.eveonline.com";
    }
}