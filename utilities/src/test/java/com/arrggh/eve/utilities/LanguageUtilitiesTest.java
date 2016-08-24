package com.arrggh.eve.utilities;

import org.junit.Test;

import static com.arrggh.eve.utilities.LanguageUtilities.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LanguageUtilitiesTest {
    @Test
    public void testIsNull() {
        assertTrue(isNull(null));
        assertFalse(isNull(this));
    }

    @Test
    public void testIsNotNull() {
        assertFalse(isNotNull(null));
        assertTrue(isNotNull(this));
    }

    @Test
    public void testNot() {
        assertTrue(not(false));
        assertFalse(not(true));
        assertTrue(not(1 != 1));
        assertFalse(not(1 == 1));
    }

}