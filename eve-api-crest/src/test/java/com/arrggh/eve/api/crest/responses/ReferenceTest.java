package com.arrggh.eve.api.crest.responses;

public class ReferenceTest extends BasicResponseObjectValidation<Reference> {

    @Override
    protected Class<Reference> getClassUnderTest() {
        return Reference.class;
    }

    @Override
    protected Reference getObjectUnderTest() {
        return Reference.builder().build();
    }
}