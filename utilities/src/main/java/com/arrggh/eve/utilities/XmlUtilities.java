package com.arrggh.eve.utilities;

import org.jdom2.Element;

/**
 * A set of helper methods to make working with JDOM XML elements easier.
 */
public interface XmlUtilities {
    /**
     * Get the named attribute from the XML element and convert it into a double.
     *
     * Note: This will currently throw an NumberFormatException if we cannot convert and a NullPointerException if the
     * attribute does not exist.
     *
     * @param element the XML element
     * @param attributeName the attribute name to retrieve
     * @return the double value
     */
    static double getDouble(Element element, String attributeName) {
        return Double.parseDouble(element.getAttributeValue(attributeName));
    }

    /**
     * Get the named attribute from the XML element and convert it into a long.
     *
     * Note: This will currently throw an NumberFormatException if we cannot convert and a NullPointerException if the
     * attribute does not exist.
     *
     * @param element the XML element
     * @param attributeName the attribute name to retrieve
     * @return the long value
     */
    static long getLong(Element element, String attributeName) {
        return Long.parseLong(element.getAttributeValue(attributeName));
    }
}
