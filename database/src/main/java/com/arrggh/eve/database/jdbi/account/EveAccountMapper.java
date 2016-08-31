package com.arrggh.eve.database.jdbi.account;

import com.arrggh.eve.model.account.EveAccount;
import com.arrggh.eve.utilities.queries.CachedResponse;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

public class EveAccountMapper implements ResultSetMapper<EveAccount> {
    @Override
    public EveAccount map(int index, ResultSet resultSet, StatementContext context) throws SQLException {
        long id  = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return EveAccount.builder().id(id).name(name).build();
    }
}
