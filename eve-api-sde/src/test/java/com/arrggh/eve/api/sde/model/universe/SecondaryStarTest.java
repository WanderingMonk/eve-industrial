package com.arrggh.eve.api.sde.model.universe;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class SecondaryStarTest extends BasicModelObjectValidation<SecondaryStar> {
  protected Class<SecondaryStar> getClassUnderTest() {
    return SecondaryStar.class;
  }

  protected SecondaryStar getInstanceUnderTest() {
    return new SecondaryStar.SecondaryStarBuilder().build();
  }

}
