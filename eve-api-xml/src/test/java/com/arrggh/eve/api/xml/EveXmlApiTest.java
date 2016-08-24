package com.arrggh.eve.api.xml;

import com.arrggh.eve.api.xml.authentication.XmlApiKey;
import com.arrggh.eve.api.xml.queries.LocalhostQueryUriBuilder;
import com.arrggh.eve.api.xml.responses.account.EveCharacter;
import com.arrggh.eve.api.xml.responses.character.CharacterIndustryJob;
import com.arrggh.eve.api.xml.responses.character.EveLocation;
import com.arrggh.eve.api.xml.responses.character.OwnedAsset;
import com.arrggh.eve.api.xml.responses.character.OwnedBlueprint;
import com.arrggh.eve.utilities.cache.MemoryCache;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.apache.commons.io.IOUtils;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class EveXmlApiTest {
    private final String assetsBody;
    private final String blueprintBody;
    private final String industryJobsBody;
    private final String locationBody;
    private final String charactersBody;
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(options().dynamicPort());

    private static final XmlApiKey key = XmlApiKey.builder().name("name").keyId("key").verificationCode("code").build();

    public EveXmlApiTest() throws IOException {
        assetsBody = IOUtils.toString(OwnedAsset.class.getResourceAsStream("assets.xml"), "utf-8");
        blueprintBody = IOUtils.toString(OwnedBlueprint.class.getResourceAsStream("blueprints.xml"), "utf-8");
        industryJobsBody = IOUtils.toString(CharacterIndustryJob.class.getResourceAsStream("industry-jobs.xml"), "utf-8");
        locationBody = IOUtils.toString(EveLocation.class.getResourceAsStream("locations.xml"), "utf-8");
        charactersBody = IOUtils.toString(EveCharacter.class.getResourceAsStream("characters.xml"), "utf-8");
    }

    @Test
    public void testGetAccount() {
        EveXmlApi api = new EveXmlApi(new MemoryCache(), new LocalhostQueryUriBuilder(wireMockRule.port()));

        String url = "/account/Characters.xml.aspx?keyID=key&vCode=code";
        wireMockRule.stubFor(get(urlEqualTo(url)).willReturn(aResponse().withBody(assetsBody).withStatus(200)));

        api.getAccount(key);
    }

    @Test
    public void testGetAssets() {
        EveXmlApi api = new EveXmlApi(new MemoryCache(), new LocalhostQueryUriBuilder(wireMockRule.port()));

        String url = "/char/AssetList.xml.aspx?keyID=key&vCode=code&characterID=characterId&flat=1";
        wireMockRule.stubFor(get(urlEqualTo(url)).willReturn(aResponse().withBody(assetsBody).withStatus(200)));

        api.getAssets(key, "characterId");
    }

    @Test
    public void testGetBlueprints() {
        EveXmlApi api = new EveXmlApi(new MemoryCache(), new LocalhostQueryUriBuilder(wireMockRule.port()));

        String url = "/char/Blueprints.xml.aspx?keyID=key&vCode=code&characterID=characterId";
        wireMockRule.stubFor(get(urlEqualTo(url)).willReturn(aResponse().withBody(blueprintBody).withStatus(200)));

        api.getBlueprints(key, "characterId");
    }

    @Test
    public void testGetCharacterList() {
        EveXmlApi api = new EveXmlApi(new MemoryCache(), new LocalhostQueryUriBuilder(wireMockRule.port()));

        String url = "/account/Characters.xml.aspx?keyID=key&vCode=code";
        wireMockRule.stubFor(get(urlEqualTo(url)).willReturn(aResponse().withBody(charactersBody).withStatus(200)));

        api.getCharacterList(key);
    }

    @Test
    public void testGetIndustryJobs() {
        EveXmlApi api = new EveXmlApi(new MemoryCache(), new LocalhostQueryUriBuilder(wireMockRule.port()));

        String url = "/char/IndustryJobs.xml.aspx?keyID=key&vCode=code&characterID=characterId";
        wireMockRule.stubFor(get(urlEqualTo(url)).willReturn(aResponse().withBody(industryJobsBody).withStatus(200)));

        api.getIndustryJobs(key, "characterId");
    }

    @Test
    public void testGetLocation() {
        EveXmlApi api = new EveXmlApi(new MemoryCache(), new LocalhostQueryUriBuilder(wireMockRule.port()));

        String url = "/char/Locations.xml.aspx?keyID=key&vCode=code&characterID=characterId&ids=locationId";
        wireMockRule.stubFor(get(urlEqualTo(url)).willReturn(aResponse().withBody(locationBody).withStatus(200)));

        api.getLocations(key, "characterId", "locationId");
    }
}