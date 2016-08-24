package com.arrggh.eve.utilities.cache;

import java.util.Optional;

/**
 * A simple interface for a Cache.
 */
public interface ICache<T> {
    /**
     * Put an optional object into the cache under the supplied key.
     *
     * Note: Passing in an Optional.empty() should indicates the delete operation, normally.
     *
     * @param key the key to store the contents under
     * @param contents the actual contents
     */
    void put(String key, Optional<T> contents);

    /**
     * Get the object from the cache using the supplied key.
     *
     * Will return Optional.empty() if the object cannot be found using the key.
     *
     * @param key The key to retrive
     * @return the contents or Optional.empty()
     */
    Optional<T> get(String key);
}