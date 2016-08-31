package com.arrggh.eve.model.account;

import com.arrggh.eve.model.BasicModelObjectValidations;

public class EveAccountTest extends BasicModelObjectValidations<EveAccount> {
    @Override
    protected Class<EveAccount> getClassUnderTest() {
        return EveAccount.class;
    }

    @Override
    protected EveAccount getObjectUnderTest() {
        return EveAccount.builder().build();
    }
}