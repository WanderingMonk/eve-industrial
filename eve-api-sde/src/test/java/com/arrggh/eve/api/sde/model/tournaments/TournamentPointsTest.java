package com.arrggh.eve.api.sde.model.tournaments;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class TournamentPointsTest extends BasicModelObjectValidation<TournamentPoints> {
  protected Class<TournamentPoints> getClassUnderTest() {
    return TournamentPoints.class;
  }

  protected TournamentPoints getInstanceUnderTest() {
    return new TournamentPoints.TournamentPointsBuilder().build();
  }

}
