package com.arrggh.eve.api.sde.model.universe;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class SolarSystemTest extends BasicModelObjectValidation<SolarSystem> {
  protected Class<SolarSystem> getClassUnderTest() {
    return SolarSystem.class;
  }

  protected SolarSystem getInstanceUnderTest() {
    return new SolarSystem.SolarSystemBuilder().build();
  }

}
