package com.arrggh.eve.utilities;

import org.junit.Test;

import static com.arrggh.eve.utilities.StringUtilities.isEmptyOrNull;
import static com.arrggh.eve.utilities.StringUtilities.isValid;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtilitiesTest {
    @Test
    public void testIsEmptyOrNull() {
        assertTrue(isEmptyOrNull(null));
        assertTrue(isEmptyOrNull(""));
        assertTrue(isEmptyOrNull(" "));

        assertFalse(isEmptyOrNull("X"));
        assertFalse(isEmptyOrNull(" X"));
        assertFalse(isEmptyOrNull("X "));
        assertFalse(isEmptyOrNull("X X"));
        assertFalse(isEmptyOrNull(" X X"));
        assertFalse(isEmptyOrNull("X X "));
    }

    @Test
    public void testIsValid() {
        assertFalse(isValid(null));
        assertFalse(isValid(""));
        assertFalse(isValid(" "));

        assertTrue(isValid("X"));
        assertTrue(isValid(" X"));
        assertTrue(isValid("X "));
        assertTrue(isValid("X X"));
        assertTrue(isValid(" X X"));
        assertTrue(isValid("X X "));
    }
}