package com.arrggh.eve.api.sde.model.universe;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class MoonTest extends BasicModelObjectValidation<Moon> {
  protected Class<Moon> getClassUnderTest() {
    return Moon.class;
  }

  protected Moon getInstanceUnderTest() {
    return new Moon.MoonBuilder().build();
  }

}
