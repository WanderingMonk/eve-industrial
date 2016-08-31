package com.arrggh.eve.model.account;


import com.arrggh.eve.model.BasicModelObjectValidations;

public class XmlApiKeyTest extends BasicModelObjectValidations<XmlApiKey> {

    @Override
    protected Class<XmlApiKey> getClassUnderTest() {
        return XmlApiKey.class;
    }

    @Override
    protected XmlApiKey getObjectUnderTest() {
        return XmlApiKey.builder().build();
    }
}