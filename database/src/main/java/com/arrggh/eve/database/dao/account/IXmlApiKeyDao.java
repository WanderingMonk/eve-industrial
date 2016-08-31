package com.arrggh.eve.database.dao.account;

import com.arrggh.eve.database.jdbi.account.EveCharacterMapper;
import com.arrggh.eve.database.jdbi.account.XmlApiKeyMapper;
import com.arrggh.eve.model.account.XmlApiKey;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(XmlApiKeyMapper.class)
public interface IXmlApiKeyDao {
    @SqlUpdate("INSERT INTO xml_api_keys(account_id, key_id, v_code) VALUES(:account_id, :key_id, :v_code)")
    void insertKey(@Bind("account_id") long id, @Bind("key_id") String keyId, @Bind("v_code") String vCode);

    @SqlQuery("SELECT account_id, key_id, v_code FROM xml_api_keys")
    List<XmlApiKey> getKeys(@Bind("id")long id);
}
