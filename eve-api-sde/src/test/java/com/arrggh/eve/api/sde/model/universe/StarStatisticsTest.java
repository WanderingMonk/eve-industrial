package com.arrggh.eve.api.sde.model.universe;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class StarStatisticsTest extends BasicModelObjectValidation<StarStatistics> {
  protected Class<StarStatistics> getClassUnderTest() {
    return StarStatistics.class;
  }

  protected StarStatistics getInstanceUnderTest() {
    return new StarStatistics.StarStatisticsBuilder().build();
  }

}
