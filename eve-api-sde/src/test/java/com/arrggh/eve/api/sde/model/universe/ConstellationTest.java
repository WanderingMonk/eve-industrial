package com.arrggh.eve.api.sde.model.universe;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class ConstellationTest extends BasicModelObjectValidation<Constellation> {
  protected Class<Constellation> getClassUnderTest() {
    return Constellation.class;
  }

  protected Constellation getInstanceUnderTest() {
    return new Constellation.ConstellationBuilder().build();
  }

}
