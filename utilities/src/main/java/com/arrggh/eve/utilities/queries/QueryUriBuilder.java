package com.arrggh.eve.utilities.queries;

import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

public abstract class QueryUriBuilder {
    /**
     * Build a URI to execute a query for a specify endpoint path.
     * <p>
     * The path (e.g. <pre>/char/Locations.xml.aspx</pre>) that the resulting URI will target, adding the keyID and
     * vCode from the EVE API key to the URI as query parameters. The parameters should be supplied as a set of paired
     * strings in the order of "name,value,name,value".
     *
     * @param path       the query path
     * @param parameters a set of parameter pairs
     * @return the resulting URI
     */
    public URI buildUrl(String path, String... parameters) {
        if (parameters.length % 2 != 0) {
            throw new IllegalArgumentException("Expected an even number of parameters [" + Arrays.toString(parameters) + "]");
        }
        try {
            URIBuilder builder = new URIBuilder();

            builder.setScheme(getScheme());
            builder.setHost(getHostname());
            builder.setPort(getPort());
            builder.setPath(path);
            for (int i = 0; i != parameters.length / 2; i++) {
                builder.setParameter(parameters[i * 2], parameters[i * 2 + 1]);
            }

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
     * <p>
     * This is the only thing that needs to differ when accessing either Tranquility (Production) or Singularity (Test)
     * EVE environments.
     *
     * @return the hostname
     */
    protected abstract String getHostname();
}


