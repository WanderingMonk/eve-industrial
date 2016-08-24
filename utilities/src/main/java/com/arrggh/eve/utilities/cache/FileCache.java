package com.arrggh.eve.utilities.cache;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import static com.arrggh.eve.utilities.LanguageUtilities.not;

/**
 * An implementation of the ICache interface, backed by a file based stored of content.
 */
public class FileCache implements ICache<String> {
    private File cacheDirectory;

    public FileCache(File directory) {
        this.cacheDirectory = directory;
    }

    @Override
    public void put(String key, Optional<String> contents) {
        File entry = new File(cacheDirectory, key);
        if (not(entry.getParentFile().mkdirs())) {
            throw new CacheException("Cannot create cached directory: '" + entry + "'");
        }

        if (contents.isPresent()) {
            try {
                writeFileContents(contents.get(), entry);
            } catch (IOException e) {
                throw new CacheException("Problem writing to cached file", e);
            }
        } else {
            if (not(entry.delete())) {
                throw new CacheException("Cannot deleted unwanted cached file: '" + entry + "'");
            }
        }
    }

    @Override
    public Optional<String> get(String key) {
        File entry = new File(cacheDirectory, key);
        if (entry.exists() && entry.canRead()) {
            try {
                return Optional.of(readFileContents(entry));
            } catch (IOException e) {
                throw new CacheException("Cannot retrieve contents from cache file: '" + entry + "'");
            }
        }
        return Optional.empty();
    }

    protected void writeFileContents(String contents, File entry) throws IOException {
        FileUtils.write(entry, contents, "utf-8");
    }

    protected String readFileContents(File entry) throws IOException {
        return FileUtils.readFileToString(entry, "utf-8");
    }
}