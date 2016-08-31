package com.arrggh.eve.database.dao.account;

import com.arrggh.eve.database.jdbi.account.BindEveAccount;
import com.arrggh.eve.database.jdbi.account.EveAccountMapper;
import com.arrggh.eve.model.account.EveAccount;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(EveAccountMapper.class)
public interface IAccountDao {
    @SqlQuery("call NEXT VALUE FOR account_id_sequence")
    long getNextAccountNumber();

    @SqlUpdate("INSERT INTO accounts(id, name) VALUES(:id, :name)")
    void insert(@BindEveAccount EveAccount account);

    @SqlQuery("SELECT id, name FROM accounts")
    List<EveAccount> select();

    @SqlQuery("SELECT id, name FROM accounts WHERE id = :id")
    EveAccount select(@Bind("id") long id);
}
