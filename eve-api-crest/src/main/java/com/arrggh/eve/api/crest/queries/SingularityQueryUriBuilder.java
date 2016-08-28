package com.arrggh.eve.api.crest.queries;

/**
 * A UriBuilder instances that targets the Test environment hostname (api-sisi.testeveonline.com).
 */
public class SingularityQueryUriBuilder extends QueryUriBuilder {
    @Override
    protected String getHostname() {
        return "api-sisi.testeveonline.com";
    }
}

