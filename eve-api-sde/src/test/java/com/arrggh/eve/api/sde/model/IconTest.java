package com.arrggh.eve.api.sde.model;

public class IconTest extends BasicModelObjectValidation<Icon> {
    protected Class<Icon> getClassUnderTest() {
        return Icon.class;
    }

    protected Icon getInstanceUnderTest() {
        return new Icon.IconBuilder().build();
    }
}
