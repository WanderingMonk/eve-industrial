package com.arrggh.eve.api.xml.parsers;

import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.assertEquals;

public class XmlExpiryTimeCalculatorTest {
    private final static XmlExpiryTimeCalculator rvc = new XmlExpiryTimeCalculator();

    private static final String BEFORE = "<eveapi><result></result><cachedUntil>";
    private static final String AFTER = "</cachedUntil></eveapi>";

    @Test
    public void testInvalidDate() {
        assertEquals(Instant.parse("2016-08-07T15:21:51Z"), rvc.apply(BEFORE + "2016-08-07 15:21:51" + AFTER));
    }

    @Test
    public void testValidDate() {
        assertEquals(Instant.parse("2999-08-07T15:21:51Z"), rvc.apply(BEFORE + "2999-08-07 15:21:51" + AFTER));
    }
}