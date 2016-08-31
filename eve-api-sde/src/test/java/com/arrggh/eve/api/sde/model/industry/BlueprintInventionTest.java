package com.arrggh.eve.api.sde.model.industry;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class BlueprintInventionTest extends BasicModelObjectValidation<BlueprintInvention> {
  protected Class<BlueprintInvention> getClassUnderTest() {
    return BlueprintInvention.class;
  }

  protected BlueprintInvention getInstanceUnderTest() {
    return new BlueprintInvention.BlueprintInventionBuilder().build();
  }
}
