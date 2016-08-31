package com.arrggh.eve.api.xml.responses.character;

import com.arrggh.eve.api.xml.responses.BasicResponseObjectValidation;

public class XmlApiEveLocationTest extends BasicResponseObjectValidation<XmlApiEveLocation> {

    @Override
    protected Class<XmlApiEveLocation> getClassUnderTest() {
        return XmlApiEveLocation.class;
    }

    @Override
    protected XmlApiEveLocation getObjectUnderTest() {
        return XmlApiEveLocation.builder().build();
    }
}