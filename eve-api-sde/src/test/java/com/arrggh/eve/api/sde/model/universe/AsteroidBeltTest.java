package com.arrggh.eve.api.sde.model.universe;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class AsteroidBeltTest extends BasicModelObjectValidation<AsteroidBelt> {
  protected Class<AsteroidBelt> getClassUnderTest() {
    return AsteroidBelt.class;
  }

  protected AsteroidBelt getInstanceUnderTest() {
    return new AsteroidBelt.AsteroidBeltBuilder().build();
  }

}
