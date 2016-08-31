package com.arrggh.eve.api.sde.model;

public class GraphicTest extends BasicModelObjectValidation<Graphic> {
    @Override
    protected Class<Graphic> getClassUnderTest() {
        return Graphic.class;
    }

    @Override
    protected Graphic getInstanceUnderTest() {
        return new Graphic.GraphicBuilder().build();
    }

}
