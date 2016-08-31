package com.arrggh.eve.api.sde.model.tournaments;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class PointTypeTest extends BasicModelObjectValidation<PointType> {
  protected Class<PointType> getClassUnderTest() {
    return PointType.class;
  }

  protected PointType getInstanceUnderTest() {
    return new PointType.PointTypeBuilder().build();
  }

}
