package com.arrggh.eve.api.sde.model.industry;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class BlueprintActivityManufacturingTest extends BasicModelObjectValidation<BlueprintActivityManufacturing> {
  protected Class<BlueprintActivityManufacturing> getClassUnderTest() {
    return BlueprintActivityManufacturing.class;
  }

  protected BlueprintActivityManufacturing getInstanceUnderTest() {
    return new BlueprintActivityManufacturing.BlueprintActivityManufacturingBuilder().build();
  }
}
