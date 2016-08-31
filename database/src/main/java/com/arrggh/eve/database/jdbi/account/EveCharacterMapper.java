package com.arrggh.eve.database.jdbi.account;

import com.arrggh.eve.model.account.EveAccount;
import com.arrggh.eve.model.account.EveCharacter;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EveCharacterMapper implements ResultSetMapper<EveCharacter> {
    @Override
    public EveCharacter map(int index, ResultSet resultSet, StatementContext context) throws SQLException {
        long id  = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return EveCharacter.builder().id(id).name(name).build();
    }
}
