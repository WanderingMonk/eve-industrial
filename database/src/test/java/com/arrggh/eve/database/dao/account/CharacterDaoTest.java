package com.arrggh.eve.database.dao.account;

import com.arrggh.eve.database.dao.DatabaseAccessObjectTest;
import com.arrggh.eve.model.account.EveAccount;
import com.arrggh.eve.model.account.EveCharacter;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CharacterDaoTest extends DatabaseAccessObjectTest {
    @Test
    public void testBasicOperations() {
        ICharacterDao dao = getDao(ICharacterDao.class);

        assertNull(dao.selectById(0));
        assertEquals(0, dao.selectByAccountId(1).size());

        EveCharacter character1 = EveCharacter.builder().id(1).name("Character 1").build();
        EveCharacter character2 = EveCharacter.builder().id(2).name("Character 2").build();

        dao.insert(0, character1);
        dao.insert(0, character2);

        assertEquals(character1, dao.selectById(1));
        assertEquals(character2, dao.selectById(2));

        List<EveCharacter> characters = dao.selectByAccountId(0);
        assertEquals(2, characters.size());
        assertTrue(characters.contains(character1));
        assertTrue(characters.contains(character2));

        dao.deleteByAccountId(0);

        assertNull(dao.selectById(1));
        assertNull(dao.selectById(2));
        assertEquals(0, dao.selectByAccountId(0).size());
    }
}
