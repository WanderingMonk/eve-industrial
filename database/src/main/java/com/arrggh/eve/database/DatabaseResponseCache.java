package com.arrggh.eve.database;

import com.arrggh.eve.database.dao.cache.ICacheDao;
import com.arrggh.eve.utilities.cache.ICache;
import com.arrggh.eve.utilities.queries.CachedResponse;

import java.util.Optional;

public class DatabaseResponseCache implements ICache<CachedResponse> {
    private final ICacheDao cacheDao;

    public DatabaseResponseCache(ICacheDao cacheDao) {
        this.cacheDao = cacheDao;
    }

    @Override
    public void put(String key, Optional<CachedResponse> contents) {
        if (contents.isPresent()) {
            cacheDao.delete(key);
            cacheDao.insert(key, contents.get());
        }
        else
            cacheDao.delete(key);
    }

    @Override
    public Optional<CachedResponse> get(String key) {
        return Optional.ofNullable(cacheDao.select(key));
    }
}
