package com.arrggh.eve.api.xml.parsers;

import com.arrggh.eve.api.xml.responses.account.XmlApiCharacter;
import com.arrggh.eve.api.xml.responses.character.XmlApiCharacterIndustryJob;
import com.arrggh.eve.api.xml.responses.character.XmlApiEveLocation;
import com.arrggh.eve.api.xml.responses.character.XmlApiOwnedAsset;
import com.arrggh.eve.api.xml.responses.character.XmlApiOwnedBlueprint;
import com.arrggh.eve.utilities.exceptions.ParserException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import static com.arrggh.eve.utilities.XmlUtilities.getDouble;
import static com.arrggh.eve.utilities.XmlUtilities.getLong;


public interface ResponseParsers {
    static List<XmlApiCharacter> parseCharacterList(String text) {
        List<XmlApiCharacter> results = new LinkedList<>();
        try {
            SAXBuilder jdomBuilder = new SAXBuilder();
            Document document = jdomBuilder.build(new StringReader(text));

            List<Element> rows = document.getRootElement().getChild("result").getChild("rowset").getChildren("row");
            for (Element row : rows) {
                XmlApiCharacter.XmlApiCharacterBuilder builder = XmlApiCharacter.builder();

                builder.id(row.getAttributeValue("characterID"));
                builder.name(row.getAttributeValue("name"));
                builder.corporationName(row.getAttributeValue("corporationName"));
                builder.corporationId(row.getAttributeValue("corporationID"));
                builder.allianceId(row.getAttributeValue("allianceID"));
                builder.allianceName(row.getAttributeValue("allianceName"));
                builder.factionId(row.getAttributeValue("factionID"));
                builder.factionName(row.getAttributeValue("factionName"));

                results.add(builder.build());
            }
        } catch (JDOMException | IOException e) {
            throw new ParserException("Cannot parse character list", e);
        }

        return results;
    }

    static List<XmlApiCharacterIndustryJob> parseIndustryJobs(String text) {
        List<XmlApiCharacterIndustryJob> results = new LinkedList<>();
        try {
            SAXBuilder jdomBuilder = new SAXBuilder();
            Document document = jdomBuilder.build(new StringReader(text));

            List<Element> rows = document.getRootElement().getChild("result").getChild("rowset").getChildren("row");
            for (Element row : rows) {
                XmlApiCharacterIndustryJob.XmlApiCharacterIndustryJobBuilder  builder = XmlApiCharacterIndustryJob.builder();

                builder.jobID(getLong(row, "jobID"));
                builder.installerID(getLong(row, "installerID"));
                builder.installerName(row.getAttributeValue("installerName"));
                builder.facilityID(getLong(row, "facilityID"));
                builder.solarSystemID(getLong(row, "solarSystemID"));
                builder.solarSystemName(row.getAttributeValue("solarSystemName"));
                builder.stationID(getLong(row, "stationID"));
                builder.activityID(getLong(row, "activityID"));
                builder.blueprintID(getLong(row, "blueprintID"));
                builder.blueprintTypeID(getLong(row, "blueprintTypeID"));
                builder.blueprintTypeName(row.getAttributeValue("blueprintTypeName"));
                builder.blueprintLocationID(getLong(row, "blueprintLocationID"));
                builder.outputLocationID(getLong(row, "outputLocationID"));
                builder.runs(getLong(row, "runs"));
                builder.cost(row.getAttributeValue("cost"));
                builder.teamID(getLong(row, "teamID"));
                builder.licensedRuns(row.getAttributeValue("licensedRuns"));
                builder.probability(row.getAttributeValue("probability"));
                builder.productTypeID(getLong(row, "productTypeID"));
                builder.productTypeName(row.getAttributeValue("productTypeName"));
                builder.status(row.getAttributeValue("status"));
                builder.timeInSeconds(getLong(row, "timeInSeconds"));
                builder.startDate(row.getAttributeValue("startDate"));
                builder.endDate(row.getAttributeValue("endDate"));
                builder.pauseDate(row.getAttributeValue("pauseDate"));
                builder.completedDate(row.getAttributeValue("completedDate"));
                builder.completedCharacterID(getLong(row, "completedCharacterID"));
                builder.successfulRuns(row.getAttributeValue("successfulRuns"));

                results.add(builder.build());
            }
        } catch (JDOMException | IOException e) {
            throw new ParserException("Cannot parse industry job", e);
        }

        return results;
    }

    static List<XmlApiOwnedBlueprint> parseBlueprints(String text) {
        List<XmlApiOwnedBlueprint> results = new LinkedList<>();
        try {
            SAXBuilder jdomBuilder = new SAXBuilder();
            Document document = jdomBuilder.build(new StringReader(text));

            List<Element> rows = document.getRootElement().getChild("result").getChild("rowset").getChildren("row");
            for (Element row : rows) {
                XmlApiOwnedBlueprint.XmlApiOwnedBlueprintBuilder builder = XmlApiOwnedBlueprint.builder();

                builder.itemId(getLong(row, "itemID"));
                builder.typeName(row.getAttributeValue("typeName"));
                builder.typeId(getLong(row, "typeID"));
                builder.flagId(getLong(row, "flagID"));
                builder.quantity(row.getAttributeValue("quantity"));
                builder.runs(row.getAttributeValue("runs"));
                builder.locationId(getLong(row, "locationID"));
                builder.materialEfficiency(row.getAttributeValue("materialEfficiency"));
                builder.timeEfficiency(row.getAttributeValue("timeEfficiency"));

                results.add(builder.build());
            }
        } catch (JDOMException | IOException e) {
            throw new ParserException("Cannot parse blueprints", e);
        }

        return results;
    }

    static List<XmlApiOwnedAsset> parseAssets(String text) {
        List<XmlApiOwnedAsset> results = new LinkedList<>();
        try {
            SAXBuilder jdomBuilder = new SAXBuilder();
            Document document = jdomBuilder.build(new StringReader(text));

            List<Element> rows = document.getRootElement().getChild("result").getChild("rowset").getChildren("row");
            for (Element row : rows) {
                XmlApiOwnedAsset.XmlApiOwnedAssetBuilder builder = XmlApiOwnedAsset.builder();

                builder.itemID(getLong(row, "itemID"));
                builder.locationID(getLong(row, "locationID"));
                builder.typeID(getLong(row, "typeID"));
                builder.quantity(getLong(row, "quantity"));
                builder.flag(row.getAttributeValue("flag"));
                builder.singleton(row.getAttributeValue("singleton"));
                builder.rawQuantity(row.getAttributeValue("rawQuantity"));

                results.add(builder.build());
            }
        } catch (JDOMException | IOException e) {
            throw new ParserException("Cannot parse assets", e);
        }

        return results;
    }

    static List<XmlApiEveLocation> parseLocations(String text) {
        List<XmlApiEveLocation> results = new LinkedList<>();
        try {
            SAXBuilder jdomBuilder = new SAXBuilder();
            Document document = jdomBuilder.build(new StringReader(text));

            List<Element> rows = document.getRootElement().getChild("result").getChild("rowset").getChildren("row");
            for (Element row : rows) {
                XmlApiEveLocation.XmlApiEveLocationBuilder builder = XmlApiEveLocation.builder();

                builder.itemID(getLong(row, "itemID"));
                builder.itemName(row.getAttributeValue("itemName"));
                builder.x(getDouble(row, "x"));
                builder.y(getDouble(row, "y"));
                builder.z(getDouble(row, "z"));

                results.add(builder.build());
            }
        } catch (JDOMException | IOException e) {
            throw new ParserException("Cannot parse locations", e);
        }

        return results;
    }
}
