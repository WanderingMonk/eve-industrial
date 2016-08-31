package com.arrggh.eve.api.sde.model.skins;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;


public class SkinTest extends BasicModelObjectValidation<Skin> {
  protected Class<Skin> getClassUnderTest() {
    return Skin.class;
  }

  protected Skin getInstanceUnderTest() {
    return new Skin.SkinBuilder().build();
  }

}
