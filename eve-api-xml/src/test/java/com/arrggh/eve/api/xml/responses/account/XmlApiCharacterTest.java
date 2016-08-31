package com.arrggh.eve.api.xml.responses.account;

import com.arrggh.eve.api.xml.responses.BasicResponseObjectValidation;

public class XmlApiCharacterTest extends BasicResponseObjectValidation<XmlApiCharacter> {

    @Override
    protected Class<XmlApiCharacter> getClassUnderTest() {
        return XmlApiCharacter.class;
    }

    @Override
    protected XmlApiCharacter getObjectUnderTest() {
        return XmlApiCharacter.builder().build();
    }
}