package com.arrggh.eve.api.sde.model.skins;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class SkinMaterialTest extends BasicModelObjectValidation<SkinMaterial> {
  protected Class<SkinMaterial> getClassUnderTest() {
    return SkinMaterial.class;
  }

  protected SkinMaterial getInstanceUnderTest() {
    return new SkinMaterial.SkinMaterialBuilder().build();
  }

}
