package com.arrggh.eve.api.xml.responses.character;

import com.arrggh.eve.api.xml.responses.BasicResponseObjectValidation;

public class OwnedBlueprintTest extends BasicResponseObjectValidation<OwnedBlueprint> {

    @Override
    protected Class<OwnedBlueprint> getClassUnderTest() {
        return OwnedBlueprint.class;
    }

    @Override
    protected OwnedBlueprint getObjectUnderTest() {
        return OwnedBlueprint.builder().build();
    }
}