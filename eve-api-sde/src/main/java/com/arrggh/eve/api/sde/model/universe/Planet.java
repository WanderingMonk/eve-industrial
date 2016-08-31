package com.arrggh.eve.api.sde.model.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.util.Map;

@Value
@Builder
@JsonDeserialize(builder = Planet.PlanetBuilder.class)
public class Planet {
    private final Long typeID;
    private final Long celestialIndex;
    private final Map<Long, Moon> moons;
    private final CelestialBodyAttributes planetAttributes;
    private final Double[] position;
    private final Long radius;
    private final CelestialBodyStatistics statistics;
    private final Map<Long, AsteroidBelt> asteroidBelts;
    private final Map<Long, Station> npcStations;
    private final Long planetNameID;

    @JsonPOJOBuilder(withPrefix = "")
    public static class PlanetBuilder {
    }
}
