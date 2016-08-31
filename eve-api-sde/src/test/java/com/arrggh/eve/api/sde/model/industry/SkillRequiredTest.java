package com.arrggh.eve.api.sde.model.industry;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class SkillRequiredTest extends BasicModelObjectValidation<SkillRequired> {
  protected Class<SkillRequired> getClassUnderTest() {
    return SkillRequired.class;
  }

  protected SkillRequired getInstanceUnderTest() {
    return new SkillRequired.SkillRequiredBuilder().build();
  }
}
