package com.arrggh.eve.utilities.cache;

import java.io.IOException;

public class MemoryCacheTest extends BasicCacheTest {
    @Override
    protected ICache getCacheUnderTest() throws IOException {
        return new MemoryCache();
    }
}