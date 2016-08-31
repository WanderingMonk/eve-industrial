package com.arrggh.eve.api.sde.model.industry;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class BlueprintResearchTest extends BasicModelObjectValidation<BlueprintResearch> {
  protected Class<BlueprintResearch> getClassUnderTest() {
    return BlueprintResearch.class;
  }

  protected BlueprintResearch getInstanceUnderTest() {
    return new BlueprintResearch.BlueprintResearchBuilder().build();
  }
}
