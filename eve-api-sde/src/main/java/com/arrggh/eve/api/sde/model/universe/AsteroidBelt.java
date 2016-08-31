package com.arrggh.eve.api.sde.model.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = AsteroidBelt.AsteroidBeltBuilder.class)
public class AsteroidBelt {
    private final Double[] position;
    private final CelestialBodyStatistics statistics;
    private final Long typeID;
    private final Long asteroidBeltNameID;

    @JsonPOJOBuilder(withPrefix = "")
    public static class AsteroidBeltBuilder {

    }
}
