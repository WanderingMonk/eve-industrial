package com.arrggh.eve.api.sde.model.tournaments;

import com.arrggh.eve.api.sde.model.BasicModelObjectValidation;

public class TournamentRuleSetTest extends BasicModelObjectValidation<TournamentRuleSet> {
  protected Class<TournamentRuleSet> getClassUnderTest() {
    return TournamentRuleSet.class;
  }

  protected TournamentRuleSet getInstanceUnderTest() {
    return new TournamentRuleSet.TournamentRuleSetBuilder().build();
  }

}
