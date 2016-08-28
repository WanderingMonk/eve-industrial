package com.arrggh.eve.utilities.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * An implementation of the ICache interface, backed by a memory based stored of content.
 */
public class MemoryCache<T> implements ICache<T> {
    private final Map<String, T> entries = new HashMap<>();

    @Override
    public void put(String key, Optional<T> contents) {
        if (contents.isPresent()) {
            entries.put(key, contents.get());
        } else {
            entries.remove(key);
        }
    }

    @Override
    public Optional<T> get(String key) {
        return Optional.ofNullable(entries.get(key));
    }
}
