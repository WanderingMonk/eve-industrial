package com.arrggh.eve.api.sde.model;

public class TranslatedStringTest extends BasicModelObjectValidation<TranslatedString> {
    protected Class<TranslatedString> getClassUnderTest() {
        return TranslatedString.class;
    }

    protected TranslatedString getInstanceUnderTest() {
        return new TranslatedString.TranslatedStringBuilder().build();
    }

}
