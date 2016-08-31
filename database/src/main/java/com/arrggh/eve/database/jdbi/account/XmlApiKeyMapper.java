package com.arrggh.eve.database.jdbi.account;

import com.arrggh.eve.model.account.EveCharacter;
import com.arrggh.eve.model.account.XmlApiKey;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class XmlApiKeyMapper implements ResultSetMapper<XmlApiKey> {
    @Override
    public XmlApiKey map(int index, ResultSet resultSet, StatementContext context) throws SQLException {
        String keyId = resultSet.getString("key_id");
        String vCode = resultSet.getString("v_code");
        return XmlApiKey.builder().keyId(keyId).verificationCode(vCode).build();
    }
}
