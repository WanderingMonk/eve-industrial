package com.arrggh.eve.database.dao.cache;

import com.arrggh.eve.database.jdbi.cache.BindCachedResponse;
import com.arrggh.eve.database.jdbi.cache.CachedResponseMapper;
import com.arrggh.eve.utilities.queries.CachedResponse;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(CachedResponseMapper.class)
public interface ICacheDao {
    @SqlUpdate("INSERT INTO cached_responses(key, expiry_time, document) VALUES(:key, :expiryTime, :document)")
    void insert(@Bind("key") String key, @BindCachedResponse CachedResponse cachedResponse);

    @SqlQuery("SELECT expiry_time, document FROM cached_responses WHERE key = :key")
    CachedResponse select(@Bind("key") String key);

    @SqlUpdate("DELETE FROM cached_responses WHERE key = :key")
    void delete(@Bind("key") String key);
}
