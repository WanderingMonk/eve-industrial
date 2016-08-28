package com.arrggh.eve.api.xml.authentication;

import com.arrggh.eve.api.xml.responses.BasicResponseObjectValidation;

public class EveAccountTest extends BasicResponseObjectValidation<EveAccount> {
    @Override
    protected Class<EveAccount> getClassUnderTest() {
        return EveAccount.class;
    }

    @Override
    protected EveAccount getObjectUnderTest() {
        return EveAccount.builder().build();
    }
}
