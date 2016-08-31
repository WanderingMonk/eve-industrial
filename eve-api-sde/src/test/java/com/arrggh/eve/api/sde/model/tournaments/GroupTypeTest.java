package com.arrggh.eve.api.sde.model.tournaments;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class GroupTypeTest extends BasicModelObjectValidation<GroupType> {
  protected Class<GroupType> getClassUnderTest() {
    return GroupType.class;
  }

  protected GroupType getInstanceUnderTest() {
    return new GroupType.GroupTypeBuilder().build();
  }

}
