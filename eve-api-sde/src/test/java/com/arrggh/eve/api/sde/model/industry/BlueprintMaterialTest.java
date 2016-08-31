package com.arrggh.eve.api.sde.model.industry;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class BlueprintMaterialTest extends BasicModelObjectValidation<BlueprintMaterial> {
  protected Class<BlueprintMaterial> getClassUnderTest() {
    return BlueprintMaterial.class;
  }

  protected BlueprintMaterial getInstanceUnderTest() {
    return new BlueprintMaterial.BlueprintMaterialBuilder().build();
  }
}
