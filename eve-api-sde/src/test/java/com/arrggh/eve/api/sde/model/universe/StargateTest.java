package com.arrggh.eve.api.sde.model.universe;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class StargateTest extends BasicModelObjectValidation<Stargate> {
  protected Class<Stargate> getClassUnderTest() {
    return Stargate.class;
  }

  protected Stargate getInstanceUnderTest() {
    return new Stargate.StargateBuilder().build();
  }

}
