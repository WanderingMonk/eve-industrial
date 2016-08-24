package com.arrggh.eve.api.xml.responses.character;

import com.arrggh.eve.api.xml.responses.BasicModelObjectValidation;

public class OwnedBlueprintTest extends BasicModelObjectValidation<OwnedBlueprint> {

    @Override
    protected Class<OwnedBlueprint> getClassUnderTest() {
        return OwnedBlueprint.class;
    }

    @Override
    protected OwnedBlueprint getObjectUnderTest() {
        return OwnedBlueprint.builder().build();
    }
}