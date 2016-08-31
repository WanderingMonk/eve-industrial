package com.arrggh.eve.api.sde.model.tournaments;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = TournamentRuleSet.TournamentRuleSetBuilder.class)
public class TournamentRuleSet {
    private final BannedFromTournament banned;
    private final Long maximumPilotsMatch;
    private final Long maximumPointsMatch;
    private final TournamentPoints points;
    private final String ruleSetID;
    private final String ruleSetName;

    @JsonPOJOBuilder(withPrefix = "")
    public static class TournamentRuleSetBuilder {
    }
}
