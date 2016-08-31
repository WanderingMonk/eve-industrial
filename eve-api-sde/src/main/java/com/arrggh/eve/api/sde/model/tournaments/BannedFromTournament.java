package com.arrggh.eve.api.sde.model.tournaments;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = BannedFromTournament.BannedFromTournamentBuilder.class)
public class BannedFromTournament {
    private final Long[] groups;
    private final Long[] types;

    @JsonPOJOBuilder(withPrefix = "")
    public static class BannedFromTournamentBuilder {
    }
}
