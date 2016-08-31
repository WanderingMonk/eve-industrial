package com.arrggh.eve.api.sde.model.tournaments;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class BannedFromTournamentTest extends BasicModelObjectValidation<BannedFromTournament> {
  protected Class<BannedFromTournament> getClassUnderTest() {
    return BannedFromTournament.class;
  }

  protected BannedFromTournament getInstanceUnderTest() {
    return new BannedFromTournament.BannedFromTournamentBuilder().build();
  }

}
