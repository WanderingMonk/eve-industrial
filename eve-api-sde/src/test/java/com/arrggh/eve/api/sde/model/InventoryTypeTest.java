package com.arrggh.eve.api.sde.model;

public class InventoryTypeTest extends BasicModelObjectValidation<InventoryType> {
    protected Class<InventoryType> getClassUnderTest() {
        return InventoryType.class;
    }

    protected InventoryType getInstanceUnderTest() {
        return new InventoryType.InventoryTypeBuilder().build();
    }

}
