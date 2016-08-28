package com.arrggh.eve.api.xml.queries;

import com.arrggh.eve.api.xml.parsers.ResponseParsers;
import com.arrggh.eve.api.xml.parsers.XmlExpiryTimeCalculator;
import com.arrggh.eve.api.xml.responses.character.EveLocation;
import com.arrggh.eve.utilities.cache.MemoryCache;
import com.arrggh.eve.utilities.queries.CachedExternalQueryService;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.apache.commons.io.IOUtils;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.Assert.assertEquals;

public class CachedExternalQueryServiceTest {
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(options().dynamicPort());

    private static final XmlExpiryTimeCalculator checker = new XmlExpiryTimeCalculator();

    private final String oldBody;
    private final String newBody;

    public CachedExternalQueryServiceTest() throws IOException {
        oldBody = IOUtils.toString(CachedExternalQueryServiceTest.class.getResourceAsStream("in-the-past-locations.xml"), "utf-8");
        newBody = IOUtils.toString(CachedExternalQueryServiceTest.class.getResourceAsStream("long-lived-locations.xml"), "utf-8");
    }

    @Test
    public void testUsesCachedFileWhenItIsStilLValid() throws IOException {
        wireMockRule.stubFor(get(urlEqualTo("/test")).willReturn(aResponse().withBody(newBody).withStatus(200)));

        URI url = URI.create("http://localhost:" + wireMockRule.port() + "/test");
        CachedExternalQueryService queryService = new CachedExternalQueryService(new MemoryCache());
        List<EveLocation> locations = queryService.get("test", ResponseParsers::parseLocations, checker, url).get();
        assertEquals(2, locations.size());

        // If the api gets called again we will die with see that we have 3 locations and not the 2 in the cached file
        wireMockRule.stubFor(get(urlEqualTo("/test")).willReturn(aResponse().withBody(oldBody).withStatus(200)));

        List<EveLocation> shouldBeCached = queryService.get("test", ResponseParsers::parseLocations, checker, url).get();
        assertEquals(2, shouldBeCached.size());
    }

    @Test
    public void testWillCallApiAgainIfCachedFileIsOld() throws IOException {
        wireMockRule.stubFor(get(urlEqualTo("/test")).willReturn(aResponse().withBody(oldBody).withStatus(200)));

        URI url = URI.create("http://localhost:" + wireMockRule.port() + "/test");
        CachedExternalQueryService queryService = new CachedExternalQueryService(new MemoryCache());
        List<EveLocation> locations = queryService.get("test", ResponseParsers::parseLocations, checker, url).get();
        assertEquals(3, locations.size());

        // If we don't get the new file then we will still have 3 locations
        wireMockRule.stubFor(get(urlEqualTo("/test")).willReturn(aResponse().withBody(newBody).withStatus(200)));

        List<EveLocation> shouldBeCached = queryService.get("test", ResponseParsers::parseLocations, checker, url).get();
        assertEquals(2, shouldBeCached.size());
    }

    @Test
    public void testWillUsedCachedFileIfApiReturnsError() throws IOException {
        wireMockRule.stubFor(get(urlEqualTo("/test")).willReturn(aResponse().withBody(oldBody).withStatus(200)));

        URI url = URI.create("http://localhost:" + wireMockRule.port() + "/test");
        CachedExternalQueryService queryService = new CachedExternalQueryService(new MemoryCache());
        List<EveLocation> locations = queryService.get("test", ResponseParsers::parseLocations, checker, url).get();
        assertEquals(3, locations.size());

        // If we ignore the error result code then we will have 2 locations instead of 3
        wireMockRule.stubFor(get(urlEqualTo("/test")).willReturn(aResponse().withBody(newBody).withStatus(500)));

        List<EveLocation> shouldBeCached = queryService.get("test", ResponseParsers::parseLocations, checker, url).get();
        assertEquals(3, shouldBeCached.size());
    }

    @Test
    public void testWillUsedCachedFileIfApiReturnsAnUnParsableFile() throws IOException {
        wireMockRule.stubFor(get(urlEqualTo("/test")).willReturn(aResponse().withBody(oldBody).withStatus(200)));

        URI url = URI.create("http://localhost:" + wireMockRule.port() + "/test");
        CachedExternalQueryService queryService = new CachedExternalQueryService(new MemoryCache());
        List<EveLocation> locations = queryService.get("test", ResponseParsers::parseLocations, checker, url).get();
        assertEquals(3, locations.size());

        // This should not parse so we should reuse the cached file even though it is old
        wireMockRule.stubFor(get(urlEqualTo("/test")).willReturn(aResponse().withBody("<asjdlksak").withStatus(500)));

        List<EveLocation> shouldBeCached = queryService.get("test", ResponseParsers::parseLocations, checker, url).get();
        assertEquals(3, shouldBeCached.size());
    }
}