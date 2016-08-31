package com.arrggh.eve.api.sde.model;

public class CategoryTest extends BasicModelObjectValidation<Category> {
    @Override
    protected Class<Category> getClassUnderTest() {
        return Category.class;
    }

    @Override
    protected Category getInstanceUnderTest() {
        return new Category.CategoryBuilder().build();
    }
}
