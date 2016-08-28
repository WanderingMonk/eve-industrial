package com.arrggh.eve.api.crest.queries;

import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public abstract class QueryUriBuilder {
    /**
     * Build a URI to execute a query for a specify endpoint path.
     *
     * The path that the resulting URI will target on the appropriate server.
     *
     * @param path the query path
     * @return the resulting URI
     */
    public URI buildUrl(String path) {
        try {
            URIBuilder builder = new URIBuilder();

            builder.setScheme(getScheme());
            builder.setHost(getHostname());
            builder.setPort(getPort());
            builder.setPath(path);

            return builder.build();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Problem building url", e);
        }
    }

    /**
     * The scheme to put on the front of the URI, defaults to "https".
     *
     * @return the HTTP scheme
     */
    protected String getScheme() {
        return "https";
    }

    /**
     * The port to access on the hostname, defaults to "443".
     *
     * @return the HTTP scheme
     */
    protected int getPort() {
        return 443;
    }

    /**
     * The hostname to put into the URI.
     *
     * This is the only thing that needs to differ when accessing either Tranquility (Production) or Singularity (Test)
     * EVE environments.
     *
     * @return the hostname
     */
    protected abstract String getHostname();
}


