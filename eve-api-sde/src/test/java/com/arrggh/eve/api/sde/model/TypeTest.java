package com.arrggh.eve.api.sde.model;

public class TypeTest extends BasicModelObjectValidation<Type> {
    protected Class<Type> getClassUnderTest() {
        return Type.class;
    }

    protected Type getInstanceUnderTest() {
        return new Type.TypeBuilder().build();
    }
}
