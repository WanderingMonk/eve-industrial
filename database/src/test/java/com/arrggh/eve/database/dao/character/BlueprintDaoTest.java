package com.arrggh.eve.database.dao.character;

import com.arrggh.eve.database.dao.DatabaseAccessObjectTest;
import com.arrggh.eve.model.character.EveBlueprint;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BlueprintDaoTest extends DatabaseAccessObjectTest {
    @Test
    public void testBasicOperations() {
        IBlueprintDao dao = getDao(IBlueprintDao.class);

        assertEquals(0, dao.selectByCharacterId(1).size());

        EveBlueprint blueprint1 = EveBlueprint.builder().id(1).name("Blueprint 1").build();
        EveBlueprint blueprint2 = EveBlueprint.builder().id(2).name("Blueprint 2").build();

        dao.insert(1, blueprint1);
        dao.insert(1, blueprint2);

        List<EveBlueprint> blueprints = dao.selectByCharacterId(1);
        assertEquals(2, blueprints.size());
        assertTrue(blueprints.contains(blueprint1));
        assertTrue(blueprints.contains(blueprint2));

        dao.deleteByCharacterId(1);

        assertEquals(0, dao.selectByCharacterId(1).size());
    }
}