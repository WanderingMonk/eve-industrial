package com.arrggh.eve.api.sde.model.universe;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class CelestialBodyStatisticsTest extends BasicModelObjectValidation<CelestialBodyStatistics> {
  protected Class<CelestialBodyStatistics> getClassUnderTest() {
    return CelestialBodyStatistics.class;
  }

  protected CelestialBodyStatistics getInstanceUnderTest() {
    return new CelestialBodyStatistics.CelestialBodyStatisticsBuilder().build();
  }

}
