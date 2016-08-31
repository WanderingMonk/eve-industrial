package com.arrggh.eve.api.sde.model.universe;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class PlanetTest extends BasicModelObjectValidation<Planet> {
  protected Class<Planet> getClassUnderTest() {
    return Planet.class;
  }

  protected Planet getInstanceUnderTest() {
    return new Planet.PlanetBuilder().build();
  }

}
