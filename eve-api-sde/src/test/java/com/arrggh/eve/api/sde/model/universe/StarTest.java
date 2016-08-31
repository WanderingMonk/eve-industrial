package com.arrggh.eve.api.sde.model.universe;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class StarTest extends BasicModelObjectValidation<Star> {
  protected Class<Star> getClassUnderTest() {
    return Star.class;
  }

  protected Star getInstanceUnderTest() {
    return new Star.StarBuilder().build();
  }

}
