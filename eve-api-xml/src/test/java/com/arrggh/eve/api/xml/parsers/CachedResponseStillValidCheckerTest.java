package com.arrggh.eve.api.xml.parsers;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CachedResponseStillValidCheckerTest {
    private final static CachedResponseStillValidChecker rvc = new CachedResponseStillValidChecker();

    private static final String BEFORE = "<eveapi><result><cachedUntil>";
    private static final String AFTER = "</cachedUntil></result></eveapi>";

    @Test
    public void testInvalidDate() {
        assertFalse(rvc.apply(BEFORE + "2016-08-07 15:21:51" + AFTER));
    }

    @Test
    public void testValidDate() {
        assertTrue(rvc.apply(BEFORE + "2999-08-07 15:21:51" + AFTER));
    }
}