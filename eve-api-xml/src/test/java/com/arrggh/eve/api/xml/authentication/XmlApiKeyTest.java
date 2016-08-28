package com.arrggh.eve.api.xml.authentication;

import com.arrggh.eve.api.xml.responses.BasicResponseObjectValidation;

public class XmlApiKeyTest extends BasicResponseObjectValidation<XmlApiKey> {

    @Override
    protected Class<XmlApiKey> getClassUnderTest() {
        return XmlApiKey.class;
    }

    @Override
    protected XmlApiKey getObjectUnderTest() {
        return XmlApiKey.builder().build();
    }
}