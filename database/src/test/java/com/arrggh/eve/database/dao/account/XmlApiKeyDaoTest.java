package com.arrggh.eve.database.dao.account;

import com.arrggh.eve.database.dao.DatabaseAccessObjectTest;
import com.arrggh.eve.model.account.EveCharacter;
import com.arrggh.eve.model.account.XmlApiKey;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class XmlApiKeyDaoTest extends DatabaseAccessObjectTest {
    @Test
    public void testBasicOperations() {
        IXmlApiKeyDao dao = getDao(IXmlApiKeyDao.class);

        assertEquals(0, dao.getKeys(1).size());

        dao.insertKey(1, "key", "code");

        assertEquals(1, dao.getKeys(1).size());
    }
}
