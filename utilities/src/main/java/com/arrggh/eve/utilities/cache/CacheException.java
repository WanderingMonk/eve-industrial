package com.arrggh.eve.utilities.cache;

import java.io.IOException;

public class CacheException extends RuntimeException {
    public CacheException(String message) {
        super(message);
    }

    public CacheException(String message, IOException cause) {
        super(message, cause);
    }
}
