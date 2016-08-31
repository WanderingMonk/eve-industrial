package com.arrggh.eve.database.dao.character;

import com.arrggh.eve.database.jdbi.character.BindEveBlueprint;
import com.arrggh.eve.database.jdbi.character.EveBlueprintMapper;
import com.arrggh.eve.model.character.EveBlueprint;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(EveBlueprintMapper.class)
public interface IBlueprintDao {
    @SqlUpdate("INSERT INTO blueprints(id, name, character_id) VALUES(:id, :name, :character_id)")
    void insert(@Bind("character_id") long characterId, @BindEveBlueprint EveBlueprint blueprint);

    @SqlUpdate("DELETE FROM blueprints WHERE character_id = :character_id")
    void deleteByCharacterId(@Bind("character_id") long characterId);

    @SqlQuery("SELECT id, name FROM blueprints WHERE character_id = :character_id")
    List<EveBlueprint> selectByCharacterId(@Bind("character_id") long characterId);
}
