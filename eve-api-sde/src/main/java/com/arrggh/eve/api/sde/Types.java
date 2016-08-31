package com.arrggh.eve.api.sde;

import com.arrggh.eve.api.sde.model.*;
import com.arrggh.eve.api.sde.model.certificates.Certificate;
import com.arrggh.eve.api.sde.model.industry.Blueprint;
import com.arrggh.eve.api.sde.model.skins.Skin;
import com.arrggh.eve.api.sde.model.skins.SkinLicense;
import com.arrggh.eve.api.sde.model.skins.SkinMaterial;
import com.arrggh.eve.api.sde.model.tournaments.TournamentRuleSet;
import com.arrggh.eve.api.sde.model.universe.Constellation;
import com.arrggh.eve.api.sde.model.universe.SolarSystem;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;

public class Types {
    public static final TypeReference<InventoryType[]> INVENTORY_TYPE_ARRAY = new TypeReference<InventoryType[]>() {
    };
    public static final TypeReference<Map<Long, Icon>> ICON_MAP = new TypeReference<Map<Long, Icon>>() {
    };
    public static final TypeReference<Map<Long, Graphic>> GRAPHICS_MAP = new TypeReference<Map<Long, Graphic>>() {
    };
    public static final TypeReference<Map<Long, Certificate>> CERTIFICATE_MAP = new TypeReference<Map<Long, Certificate>>() {
    };
    public static final TypeReference<Map<Long, Group>> GROUPS_MAP = new TypeReference<Map<Long, Group>>() {
    };
    public static final TypeReference<Map<Long, Category>> CATEGORY_MAP = new TypeReference<Map<Long, Category>>() {
    };
    public static final TypeReference<Map<Long, Blueprint>> BLUEPRINT_MAP = new TypeReference<Map<Long, Blueprint>>() {
    };
    public static final TypeReference<Map<Long, SkinLicense>> SKIN_LICENCE_MAP = new TypeReference<Map<Long, SkinLicense>>() {
    };
    public static final TypeReference<Map<Long, SkinMaterial>> SKIN_MATERIAL_MAP = new TypeReference<Map<Long, SkinMaterial>>() {
    };
    public static final TypeReference<Map<Long, Skin>> SKIN_MAP = new TypeReference<Map<Long, Skin>>() {
    };
    public static final TypeReference<TournamentRuleSet[]> TOURNAMENT_RULE_SET_ARRAY = new TypeReference<TournamentRuleSet[]>() {
    };
    public static final TypeReference<SolarSystem> SOLARSYSTEM_TYPE = new TypeReference<SolarSystem>() {
    };
    public static final TypeReference<Constellation> CONSTELLATION_TYPE = new TypeReference<Constellation>() {
    };
    public static final TypeReference<Map<Long,Type>> TYPE_MAP = new TypeReference<Map<Long, Type>>() {
    };
}
