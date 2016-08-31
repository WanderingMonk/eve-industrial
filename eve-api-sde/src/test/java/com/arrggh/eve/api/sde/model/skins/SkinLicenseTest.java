package com.arrggh.eve.api.sde.model.skins;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class SkinLicenseTest extends BasicModelObjectValidation<SkinLicense> {
  protected Class<SkinLicense> getClassUnderTest() {
    return SkinLicense.class;
  }

  protected SkinLicense getInstanceUnderTest() {
    return new SkinLicense.SkinLicenseBuilder().build();
  }

}
