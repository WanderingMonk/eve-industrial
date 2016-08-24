package com.arrggh.eve.api.xml.responses.account;

import com.arrggh.eve.api.xml.responses.BasicModelObjectValidation;

public class EveCharacterTest extends BasicModelObjectValidation<EveCharacter> {

    @Override
    protected Class<EveCharacter> getClassUnderTest() {
        return EveCharacter.class;
    }

    @Override
    protected EveCharacter getObjectUnderTest() {
        return EveCharacter.builder().build();
    }
}