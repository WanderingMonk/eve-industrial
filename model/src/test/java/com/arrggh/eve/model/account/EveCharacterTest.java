package com.arrggh.eve.model.account;

import com.arrggh.eve.model.BasicModelObjectValidations;

import static org.junit.Assert.*;

public class EveCharacterTest extends BasicModelObjectValidations<EveCharacter> {
    @Override
    protected Class<EveCharacter> getClassUnderTest() {
        return EveCharacter.class;
    }

    @Override
    protected EveCharacter getObjectUnderTest() {
        return EveCharacter.builder().build();
    }
}