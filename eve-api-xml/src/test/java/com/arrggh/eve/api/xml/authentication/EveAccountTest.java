package com.arrggh.eve.api.xml.authentication;

import com.arrggh.eve.api.xml.responses.BasicModelObjectValidation;

public class EveAccountTest extends BasicModelObjectValidation<EveAccount> {
    @Override
    protected Class<EveAccount> getClassUnderTest() {
        return EveAccount.class;
    }

    @Override
    protected EveAccount getObjectUnderTest() {
        return EveAccount.builder().build();
    }
}
