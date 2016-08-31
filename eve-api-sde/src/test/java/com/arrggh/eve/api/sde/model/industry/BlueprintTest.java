package com.arrggh.eve.api.sde.model.industry;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class BlueprintTest extends BasicModelObjectValidation<Blueprint> {
  protected Class<Blueprint> getClassUnderTest() {
    return Blueprint.class;
  }

  protected Blueprint getInstanceUnderTest() {
    return new Blueprint.BlueprintBuilder().build();
  }
}
