package com.arrggh.eve.api.sde;

import com.arrggh.eve.api.sde.model.*;
import com.arrggh.eve.api.sde.model.certificates.Certificate;
import com.arrggh.eve.api.sde.model.industry.Blueprint;
import com.arrggh.eve.api.sde.model.industry.BlueprintActivities;
import com.arrggh.eve.api.sde.model.industry.BlueprintActivityManufacturing;
import com.arrggh.eve.api.sde.model.industry.BlueprintMaterial;
import com.arrggh.eve.api.sde.model.skins.Skin;
import com.arrggh.eve.api.sde.model.skins.SkinLicense;
import com.arrggh.eve.api.sde.model.skins.SkinMaterial;
import com.arrggh.eve.api.sde.model.tournaments.TournamentRuleSet;
import com.arrggh.eve.api.sde.model.universe.Constellation;
import com.arrggh.eve.api.sde.model.universe.SolarSystem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class StaticDataExportImporter {
    public void importFile(File zipFile) throws IOException {
        try (ZipFile sdeZip = new ZipFile(zipFile)) {
            Map<Long, Type> types = processMap("Types", sdeZip.getInputStream(sdeZip.getEntry("sde/fsd/typeIDs.yaml")), Types.TYPE_MAP);

            List<InventoryType> items = processArray("Items", sdeZip.getInputStream(sdeZip.getEntry("sde/bsd/invItems.yaml")), Types.INVENTORY_TYPE_ARRAY);

            Map<Long, Blueprint> blueprints = processMap("Blueprint", sdeZip.getInputStream(sdeZip.getEntry("sde/fsd/blueprints.yaml")), Types.BLUEPRINT_MAP);

            for (ZipEntry entry : Collections.list(sdeZip.entries())) {
                String entryName = entry.getName();
                if (entryName.contains("sde/fsd/universe") && entryName.endsWith(".staticdata")) {
                    if (entryName.endsWith("constellation.staticdata")) {
                        Constellation constellation = process(sdeZip.getInputStream(entry), Types.CONSTELLATION_TYPE);
                    }
                    if (entryName.endsWith("solarsystem.staticdata")) {
                        SolarSystem solarsystem = process(sdeZip.getInputStream(entry), Types.SOLARSYSTEM_TYPE);
                    }
                }
            }

            Map<Long, Icon> icons = processMap("Icons", sdeZip.getInputStream(sdeZip.getEntry("sde/fsd/iconIDs.yaml")), Types.ICON_MAP);
            Map<Long, Graphic> graphics = processMap("Graphics", sdeZip.getInputStream(sdeZip.getEntry("sde/fsd/graphicIDs.yaml")), Types.GRAPHICS_MAP);
            Map<Long, Certificate> certificates = processMap("Certificates", sdeZip.getInputStream(sdeZip.getEntry("sde/fsd/certificates.yaml")), Types.CERTIFICATE_MAP);
            Map<Long, Group> groups = processMap("Groups", sdeZip.getInputStream(sdeZip.getEntry("sde/fsd/groupIDs.yaml")), Types.GROUPS_MAP);
            Map<Long, Category> categories = processMap("Categories", sdeZip.getInputStream(sdeZip.getEntry("sde/fsd/categoryIDs.yaml")), Types.CATEGORY_MAP);
            Map<Long, SkinLicense> skinLicenses = processMap("Skin Licenses", sdeZip.getInputStream(sdeZip.getEntry("sde/fsd/skinLicenses.yaml")), Types.SKIN_LICENCE_MAP);
            Map<Long, SkinMaterial> skinMaterials = processMap("Skin Materials", sdeZip.getInputStream(sdeZip.getEntry("sde/fsd/skinMaterials.yaml")), Types.SKIN_MATERIAL_MAP);
            Map<Long, Skin> skins = processMap("Skins", sdeZip.getInputStream(sdeZip.getEntry("sde/fsd/skins.yaml")), Types.SKIN_MAP);
            List<TournamentRuleSet> tournamentRuleSets = processArray("Tournament Rule Sets", sdeZip.getInputStream(sdeZip.getEntry("sde/fsd/tournamentRuleSets.yaml")), Types.TOURNAMENT_RULE_SET_ARRAY);
        }
    }

//    private static void insertBlueprints(Map<Long, Blueprint> blueprints) {
//        for (Map.Entry<Long, Blueprint> entry : blueprints.entrySet()) {
//            Long id = entry.getKey();
//            Blueprint blueprint = entry.getValue();
//
//            BlueprintActivities activities = blueprint.getActivities();
//            if (activities == null) {
//                System.err.println("Blueprint " + id + " has no activities??");
//                continue;
//            }
//
//            BlueprintActivityManufacturing manufacturing = activities.getManufacturing();
//            if (manufacturing == null) {
//                System.err.println("Blueprint " + id + " has no manufacturing??");
//                continue;
//            }
//
//            BlueprintMaterial[] produces = manufacturing.getProducts();
//            if (produces == null) {
//                System.err.println("Blueprint " + id + " produces nothing??");
//                continue;
//            }
//
//            if (produces.length > 1) {
//                System.err.println("Blueprint " + id + " produces more than one item??");
//                continue;
//            }
//
////            EveBlueprint bp = EveBlueprint.builder() //
////                    .id(id) //
////                    .typeId(blueprint.getBlueprintTypeID()) //
////                    .maxProductionLimit(blueprint.getMaxProductionLimit()) //
////                    .build();
////            blueprintDao.save(bp);
//        }
//    }

    private static ObjectMapper mapper = new ObjectMapper(new YAMLFactory()) //
            .enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES) //
            .enable(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS) //
            .enable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY) //
            .enable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES) //
            .enable(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES) //
            .enable(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES) //
            .disable(DeserializationFeature.ACCEPT_FLOAT_AS_INT);

    private static <T> T process(InputStream inputStream, TypeReference<T> typeReference) throws IOException {
        String yaml = IOUtils.toString(inputStream, "utf-8");
        try {
            return mapper.readValue(yaml, typeReference);
        } catch (IOException e) {
            System.out.println(e.getMessage());
//            System.out.println(yaml);
            throw e;
        }
    }

    private static <T> T processMap(String what, InputStream inputStream, TypeReference<T> typeReference) throws IOException {
        String yaml = IOUtils.toString(inputStream, "utf-8");
        try {
            T result = mapper.readValue(yaml, typeReference);
            return result;
        } catch (IOException e) {
            System.out.println("Error loading " + what + ":" + e.getMessage());
//            System.out.println(yaml);
            throw e;
        }
    }

    private static <T> List<T> processArray(String what, InputStream inputStream, TypeReference<T[]> typeReference) throws IOException {
        String yaml = IOUtils.toString(inputStream, "utf-8");
        try {
            T[] result = mapper.readValue(yaml, typeReference);
            return Arrays.asList(result);
        } catch (IOException e) {
            System.out.println("Error loading " + what + ":" + e.getMessage());
//            System.out.println(yaml);
            throw e;
        }
    }

    public static void main(String[] args) throws IOException {
        StaticDataExportImporter importer = new StaticDataExportImporter();
        importer.importFile(new File("/home/monk/EveSDE/sde-20160809-TRANQUILITY.zip"));
    }
}
