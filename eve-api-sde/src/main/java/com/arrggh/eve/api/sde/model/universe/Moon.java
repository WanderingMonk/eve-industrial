package com.arrggh.eve.api.sde.model.universe;

import com.arrggh.eve.api.sde.model.universe.CelestialBodyAttributes;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.util.Map;

@Value
@Builder
@JsonDeserialize(builder = Moon.MoonBuilder.class)
public class Moon {
    private final Long celestialIndex;
    private final CelestialBodyAttributes planetAttributes;
    private final Double[] position;
    private final Double radius;
    private final CelestialBodyStatistics statistics;
    private final Long typeID;
    private final Map<Long, Station> npcStations;
    private final Long moonNameID;

    @JsonPOJOBuilder(withPrefix = "")
    public static class MoonBuilder {
    }
}
