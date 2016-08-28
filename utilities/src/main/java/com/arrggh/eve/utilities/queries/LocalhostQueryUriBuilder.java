package com.arrggh.eve.utilities.queries;

public class LocalhostQueryUriBuilder extends QueryUriBuilder {

    private final int port;

    public LocalhostQueryUriBuilder(int port) {
        this.port = port;
    }

    @Override
    protected String getHostname() {
        return "localhost";
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getScheme() {
        return "http";
    }
}
