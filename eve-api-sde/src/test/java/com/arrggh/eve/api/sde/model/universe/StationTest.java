package com.arrggh.eve.api.sde.model.universe;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class StationTest extends BasicModelObjectValidation<Station> {
  protected Class<Station> getClassUnderTest() {
    return Station.class;
  }

  protected Station getInstanceUnderTest() {
    return new Station.StationBuilder().build();
  }

}
