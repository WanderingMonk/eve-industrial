package com.arrggh.eve.api.xml.responses.character;

import com.arrggh.eve.api.xml.responses.BasicResponseObjectValidation;

public class XmlApiOwnedBlueprintTest extends BasicResponseObjectValidation<XmlApiOwnedBlueprint> {

    @Override
    protected Class<XmlApiOwnedBlueprint> getClassUnderTest() {
        return XmlApiOwnedBlueprint.class;
    }

    @Override
    protected XmlApiOwnedBlueprint getObjectUnderTest() {
        return XmlApiOwnedBlueprint.builder().build();
    }
}