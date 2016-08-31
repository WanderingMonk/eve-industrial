package com.arrggh.eve.database.dao.cache;

import com.arrggh.eve.database.dao.DatabaseAccessObjectTest;
import com.arrggh.eve.utilities.queries.CachedResponse;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CacheDaoTest extends DatabaseAccessObjectTest {
    @Test
    public void testBasicOperations() {
        ICacheDao dao = getDao(ICacheDao.class);

        CachedResponse response = CachedResponse.builder()//
                .expiryTime(Instant.now()) //
                .document("document") //
                .build();

        dao.insert("key", response);

        CachedResponse selected = dao.select("key");
        assertNotNull(selected);
        assertEquals(response, selected);

        assertNull(dao.select("key-not-found"));

        dao.delete("key");

        assertNull(dao.select("key"));
        assertNull(dao.select("key-not-found"));
    }
}
