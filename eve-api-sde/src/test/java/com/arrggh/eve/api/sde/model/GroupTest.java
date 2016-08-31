package com.arrggh.eve.api.sde.model;

public class GroupTest extends BasicModelObjectValidation<Group> {
    protected Class<Group> getClassUnderTest() {
        return Group.class;
    }

    protected Group getInstanceUnderTest() {
        return new Group.GroupBuilder().build();
    }
}
