package com.arrggh.eve.api.sde.model.certificates;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class SkillLevelTest extends BasicModelObjectValidation<SkillLevel> {
  protected Class<SkillLevel> getClassUnderTest() {
    return SkillLevel.class;
  }

  protected SkillLevel getInstanceUnderTest() {
    return new SkillLevel.SkillLevelBuilder().build();
  }

}
