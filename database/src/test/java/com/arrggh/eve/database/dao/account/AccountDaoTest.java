package com.arrggh.eve.database.dao.account;

import com.arrggh.eve.database.dao.DatabaseAccessObjectTest;
import com.arrggh.eve.model.account.EveAccount;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AccountDaoTest extends DatabaseAccessObjectTest {
    @Test
    public void testBasicOperations() {
        IAccountDao dao = getDao(IAccountDao.class);

        long id = dao.getNextAccountNumber();
        assertEquals(id + 1, dao.getNextAccountNumber());

        EveAccount account1 = EveAccount.builder().id(1).name("Account #1").build();
        EveAccount account2 = EveAccount.builder().id(2).name("Account #2").build();

        assertEquals(0, dao.select().size());
        assertNull(dao.select(1));
        assertNull(dao.select(2));

        dao.insert(account1);
        dao.insert(account2);

        List<EveAccount> accounts = dao.select();
        assertEquals(2, accounts.size());
        assertTrue(accounts.contains(account1));
        assertTrue(accounts.contains(account2));

        assertEquals(account1, dao.select(1));
        assertEquals(account2, dao.select(2));
    }
}
