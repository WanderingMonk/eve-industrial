package com.arrggh.eve.utilities.cache;

import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public abstract class BasicCacheTest {
    protected abstract ICache getCacheUnderTest() throws IOException;

    @Test
    public void testCacheCanAddFetchAndDelete() throws IOException {
        ICache cache = getCacheUnderTest();
        cache.put("key", Optional.of("value"));
        assertEquals("value", cache.get("key").get());
        assertEquals(Optional.empty(), cache.get("key2"));

        cache.put("key", Optional.empty());
        assertEquals(Optional.empty(), cache.get("key"));
        assertEquals(Optional.empty(), cache.get("key2"));
    }

}
