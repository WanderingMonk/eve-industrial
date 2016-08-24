package com.arrggh.eve.api.xml.queries;

import com.arrggh.eve.api.xml.authentication.XmlApiKey;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryUriBuilderTest {
    @Test
    public void testUrlBuildersWithOutParameters() {
        SingularityQueryUriBuilder sUrlBuilder = new SingularityQueryUriBuilder();
        TranquilityQueryUriBuilder tUrlBuilder = new TranquilityQueryUriBuilder();

        XmlApiKey key = XmlApiKey.builder().name("name").keyId("key").verificationCode("code").build();

        String sUrl = sUrlBuilder.buildUrl("/path", key).toASCIIString();
        String tUrl = tUrlBuilder.buildUrl("/path", key).toASCIIString();

        assertEquals("https://api.testeveonline.com:443/path?keyID=key&vCode=code", sUrl);
        assertEquals("https://api.eveonline.com:443/path?keyID=key&vCode=code", tUrl);
    }

    @Test
    public void testUrlBuildersWithParameters() {
        SingularityQueryUriBuilder sUrlBuilder = new SingularityQueryUriBuilder();
        TranquilityQueryUriBuilder tUrlBuilder = new TranquilityQueryUriBuilder();

        XmlApiKey key = XmlApiKey.builder().name("name").keyId("key").verificationCode("code").build();

        String sUrl = sUrlBuilder.buildUrl("/path", key, "a", "b").toASCIIString();
        String tUrl = tUrlBuilder.buildUrl("/path", key, "a", "b").toASCIIString();

        assertEquals("https://api.testeveonline.com:443/path?keyID=key&vCode=code&a=b", sUrl);
        assertEquals("https://api.eveonline.com:443/path?keyID=key&vCode=code&a=b", tUrl);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSingularityUrlBuilderWithMismatchedParameters() {
        SingularityQueryUriBuilder sUrlBuilder = new SingularityQueryUriBuilder();
        XmlApiKey key = XmlApiKey.builder().name("name").keyId("key").verificationCode("code").build();
        sUrlBuilder.buildUrl("path", key, "a").toASCIIString();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTranquilityUrlBuilderWithMismatchedParameters() {
        TranquilityQueryUriBuilder tUrlBuilder = new TranquilityQueryUriBuilder();
        XmlApiKey key = XmlApiKey.builder().name("name").keyId("key").verificationCode("code").build();
        tUrlBuilder.buildUrl("path", key, "a").toASCIIString();
    }
}