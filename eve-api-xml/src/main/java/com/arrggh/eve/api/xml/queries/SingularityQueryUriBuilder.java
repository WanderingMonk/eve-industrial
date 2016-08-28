package com.arrggh.eve.api.xml.queries;

import com.arrggh.eve.utilities.queries.QueryUriBuilder;

/**
 * A UriBuilder instances that targets the Test environment hostname (api.testeveonline.com).
 */
public class SingularityQueryUriBuilder extends QueryUriBuilder {
    @Override
    protected String getHostname() {
        return "api.testeveonline.com";
    }
}

