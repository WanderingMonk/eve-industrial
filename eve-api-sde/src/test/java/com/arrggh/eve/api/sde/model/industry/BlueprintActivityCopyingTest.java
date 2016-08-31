package com.arrggh.eve.api.sde.model.industry;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class BlueprintActivityCopyingTest extends BasicModelObjectValidation<BlueprintActivityCopying> {
  protected Class<BlueprintActivityCopying> getClassUnderTest() {
    return BlueprintActivityCopying.class;
  }

  protected BlueprintActivityCopying getInstanceUnderTest() {
    return new BlueprintActivityCopying.BlueprintActivityCopyingBuilder().build();
  }
}
