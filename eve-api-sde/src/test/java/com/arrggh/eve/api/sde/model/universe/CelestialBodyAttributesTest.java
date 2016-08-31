package com.arrggh.eve.api.sde.model.universe;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class CelestialBodyAttributesTest extends BasicModelObjectValidation<CelestialBodyAttributes> {
  protected Class<CelestialBodyAttributes> getClassUnderTest() {
    return CelestialBodyAttributes.class;
  }

  protected CelestialBodyAttributes getInstanceUnderTest() {
    return new CelestialBodyAttributes.CelestialBodyAttributesBuilder().build();
  }

}
