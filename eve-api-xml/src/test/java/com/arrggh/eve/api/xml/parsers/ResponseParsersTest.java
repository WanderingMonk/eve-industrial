package com.arrggh.eve.api.xml.parsers;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ResponseParsersTest {
    private String getFileContents(String group, String file) throws IOException {
        String path = "/com/arrggh/eve/api/xml/responses/" + group + "/" + file + ".xml";
        String contents = IOUtils.toString(ResponseParsersTest.class.getResourceAsStream(path), "utf-8");
        Assert.assertTrue(contents.length() > 0);
        return contents;
    }

    private String getValidFileContents(String group, String file) throws IOException {
        return getFileContents(group, file);
    }

    private String getInvalidFileContents(String group, String file) throws IOException {
        return getFileContents(group, file).substring(40);
    }

    @Test
    public void testAccountCharactersValid() throws IOException {
        Assert.assertEquals(1, ResponseParsers.parseCharacterList(getValidFileContents("account", "characters")).size());
    }

    @Test(expected = ParserException.class)
    public void testAccountCharactersInvalid() throws IOException {
        Assert.assertEquals(0, ResponseParsers.parseCharacterList(getInvalidFileContents("account", "characters")).size());
    }

    @Test
    public void testOwnedAssetsValid() throws IOException {
        Assert.assertEquals(6, ResponseParsers.parseAssets(getValidFileContents("character", "assets")).size());
    }

    @Test(expected = ParserException.class)
    public void testOwnedAssetsInvalid() throws IOException {
        Assert.assertEquals(0, ResponseParsers.parseAssets(getInvalidFileContents("character", "assets")).size());
    }

    @Test
    public void testOwnedBlueprintsValid() throws IOException {
        Assert.assertEquals(3, ResponseParsers.parseBlueprints(getValidFileContents("character", "blueprints")).size());
    }

    @Test(expected = ParserException.class)
    public void testOwnedBlueprintsInvalid() throws IOException {
        Assert.assertEquals(0, ResponseParsers.parseBlueprints(getInvalidFileContents("character", "blueprints")).size());
    }

    @Test
    public void testCharacterIndustryJobsValid() throws IOException {
        Assert.assertEquals(6, ResponseParsers.parseIndustryJobs(getValidFileContents("character", "industry-jobs")).size());
    }

    @Test(expected = ParserException.class)
    public void testCharacterIndustryJobsInvalid() throws IOException {
        Assert.assertEquals(0, ResponseParsers.parseIndustryJobs(getInvalidFileContents("character", "industry-jobs")).size());
    }

    @Test
    public void testLocationsValid() throws IOException {
        Assert.assertEquals(2, ResponseParsers.parseLocations(getValidFileContents("character", "locations")).size());
    }

    @Test(expected = ParserException.class)
    public void testLocationsInvalid() throws IOException {
        Assert.assertEquals(0, ResponseParsers.parseLocations(getInvalidFileContents("character", "locations")).size());
    }
}

