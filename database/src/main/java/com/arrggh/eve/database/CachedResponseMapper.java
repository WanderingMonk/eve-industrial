package com.arrggh.eve.database;

import com.arrggh.eve.utilities.queries.CachedResponse;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

public class CachedResponseMapper implements ResultSetMapper<CachedResponse> {
    @Override
    public CachedResponse map(int index, ResultSet resultSet, StatementContext context) throws SQLException {
        String expiryTimeStr = resultSet.getString("expiry_time");
        String document = resultSet.getString("document");
        return CachedResponse.builder().expiryTime(Instant.parse(expiryTimeStr)).document(document).build();
    }
}
