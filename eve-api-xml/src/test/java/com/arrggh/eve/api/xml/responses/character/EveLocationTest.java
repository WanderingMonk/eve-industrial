package com.arrggh.eve.api.xml.responses.character;

import com.arrggh.eve.api.xml.responses.BasicModelObjectValidation;

public class EveLocationTest extends BasicModelObjectValidation<EveLocation> {

    @Override
    protected Class<EveLocation> getClassUnderTest() {
        return EveLocation.class;
    }

    @Override
    protected EveLocation getObjectUnderTest() {
        return EveLocation.builder().build();
    }
}