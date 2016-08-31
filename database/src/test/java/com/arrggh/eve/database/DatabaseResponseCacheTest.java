package com.arrggh.eve.database;

import com.arrggh.eve.database.dao.cache.ICacheDao;
import com.arrggh.eve.utilities.queries.CachedResponse;
import liquibase.exception.LiquibaseException;
import org.junit.Test;

import java.sql.SQLException;
import java.time.Instant;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class DatabaseResponseCacheTest {
    @Test
    public void testBasicCacheBehaviour() throws SQLException, LiquibaseException {
        DatabaseConnection database = new DatabaseConnection();
        database.executeQuery(new DatabaseSchemaUpdator());

        ICacheDao cacheDao = database.getDao(ICacheDao.class);

        DatabaseResponseCache cache = new DatabaseResponseCache(cacheDao);

        CachedResponse response = CachedResponse.builder().expiryTime(Instant.now()).document("test document").build();
        cache.put("test", Optional.of(response));

        assertEquals(Optional.empty(), cache.get("missing"));
        assertEquals(response, cache.get("test").get());

        cache.put("test", Optional.empty());
        assertEquals(Optional.empty(), cache.get("test"));
    }
}
