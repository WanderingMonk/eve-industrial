package com.arrggh.eve.utilities.cache;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileCacheTest extends BasicCacheTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Override
    protected ICache getCacheUnderTest() throws IOException {
        return new FileCache(folder.newFolder("cache"));
    }

    @Test
    public void testFileCacheCanHandleDeletedFile() throws IOException {
        File directory = folder.newFolder("cache");
        FileCache cache = new FileCache(directory);
        cache.put("key", Optional.of("value"));

        File cachedFile = new File(directory, "key");
        assertTrue(cachedFile.delete());

        cache.put("key", Optional.empty());
        assertEquals(Optional.empty(), cache.get("key"));
        assertEquals(Optional.empty(), cache.get("key2"));
    }

    @Test
    public void testFileCacheCanHandleReadExceptions() throws IOException {
        File directory = folder.newFolder("cache");
        FileCache cache = new FileCache(directory) {
            @Override
            protected String readFileContents(File entry) throws IOException {
                throw new IOException("Test Read Exception");
            }
        };
        cache.put("key", Optional.of("value"));
        assertEquals(Optional.empty(), cache.get("key"));
        assertEquals(Optional.empty(), cache.get("key2"));
    }

    @Test
    public void testFileCacheCanHandleWriteExceptions() throws IOException {
        File directory = folder.newFolder("cache");
        FileCache cache = new FileCache(directory) {
            @Override
            protected void writeFileContents(String contents, File entry) throws IOException {
                throw new IOException("Test Write Exception");
            }
        };
        cache.put("key", Optional.of("value"));
        assertEquals(Optional.empty(), cache.get("key"));
        assertEquals(Optional.empty(), cache.get("key2"));
    }
}