package com.arrggh.eve.api.sde.model.industry;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class BlueprintActivitiesTest extends BasicModelObjectValidation<BlueprintActivities> {
  protected Class<BlueprintActivities> getClassUnderTest() {
    return BlueprintActivities.class;
  }

  protected BlueprintActivities getInstanceUnderTest() {
    return new BlueprintActivities.BlueprintActivitiesBuilder().build();
  }
}
