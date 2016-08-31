package com.arrggh.eve.api.sde.model.tournaments;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = TournamentPoints.TournamentPointsBuilder.class)
public class TournamentPoints {
    private GroupType[] groups;
    private PointType[] types;

    @JsonPOJOBuilder(withPrefix = "")
    public static class TournamentPointsBuilder {

    }
}
