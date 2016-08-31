package com.arrggh.eve.database.dao.account;

import com.arrggh.eve.database.jdbi.account.BindEveCharacter;
import com.arrggh.eve.database.jdbi.account.EveCharacterMapper;
import com.arrggh.eve.model.account.EveCharacter;
import com.arrggh.eve.utilities.queries.CachedResponse;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(EveCharacterMapper.class)
public interface ICharacterDao {
    @SqlUpdate("INSERT INTO characters(id, name, account_id) VALUES(:id, :name, :account_id)")
    void insert(@Bind("account_id") long accountId, @BindEveCharacter EveCharacter eveCharacter);

    @SqlUpdate("DELETE FROM characters WHERE account_id = :account_id")
    void deleteByAccountId(@Bind("account_id") long accountId);

    @SqlQuery("SELECT id, name FROM characters WHERE account_id = :account_id")
    List<EveCharacter> selectByAccountId(@Bind("account_id") long accountId);

    @SqlQuery("SELECT id, name FROM characters WHERE id = :id")
    EveCharacter selectById(@Bind("id") long id);
}
