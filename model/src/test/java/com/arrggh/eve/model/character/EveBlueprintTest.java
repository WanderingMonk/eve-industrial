package com.arrggh.eve.model.character;

import com.arrggh.eve.model.BasicModelObjectValidations;


public class EveBlueprintTest extends BasicModelObjectValidations<EveBlueprint> {

    @Override
    protected Class<EveBlueprint> getClassUnderTest() {
        return EveBlueprint.class;
    }

    @Override
    protected EveBlueprint getObjectUnderTest() {
        return EveBlueprint.builder().build();
    }
}