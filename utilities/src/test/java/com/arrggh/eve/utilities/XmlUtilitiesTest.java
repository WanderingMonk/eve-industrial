package com.arrggh.eve.utilities;

import org.jdom2.Element;
import org.junit.Test;

public class XmlUtilitiesTest {
    private static final Element TEST_ELEMENT = new Element("test") //
            .setAttribute("double", "1.0") //
            .setAttribute("long", "2") //
            .setAttribute("invalid", "xxxx");

    @Test
    public void testGetLong() {
        XmlUtilities.getLong(TEST_ELEMENT, "long");
    }

    @Test
    public void testGetDouble() {
        XmlUtilities.getDouble(TEST_ELEMENT, "double");
    }

    @Test(expected = NumberFormatException.class)
    public void testGetLongWithInvalidInput() {
        XmlUtilities.getLong(TEST_ELEMENT, "invalid");
    }

    @Test(expected = NumberFormatException.class)
    public void testGetDoubleWithInvalidInput() {
        XmlUtilities.getDouble(TEST_ELEMENT, "invalid");
    }
}