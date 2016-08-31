package com.arrggh.eve.database.jdbi.character;

import com.arrggh.eve.model.account.EveAccount;
import com.arrggh.eve.model.character.EveBlueprint;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EveBlueprintMapper implements ResultSetMapper<EveBlueprint> {
    @Override
    public EveBlueprint map(int index, ResultSet resultSet, StatementContext context) throws SQLException {
        long id  = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return EveBlueprint.builder().id(id).name(name).build();
    }
}
