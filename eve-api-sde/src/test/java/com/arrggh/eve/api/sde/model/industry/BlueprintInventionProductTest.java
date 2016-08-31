package com.arrggh.eve.api.sde.model.industry;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class BlueprintInventionProductTest extends BasicModelObjectValidation<BlueprintInventionProduct> {
  protected Class<BlueprintInventionProduct> getClassUnderTest() {
    return BlueprintInventionProduct.class;
  }

  protected BlueprintInventionProduct getInstanceUnderTest() {
    return new BlueprintInventionProduct.BlueprintInventionProductBuilder().build();
  }
}
