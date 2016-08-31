package com.arrggh.eve.api.sde.model.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.util.Map;

@Value
@Builder
@JsonDeserialize(builder = SolarSystem.SolarSystemBuilder.class)
public class SolarSystem {
    private final Boolean border;
    private final Boolean corridor;
    private final Boolean fringe;
    private final Boolean hub;
    private final Boolean international;
    private final Boolean regional;
    private final Double security;
    private final String securityClass;
    private final Long solarSystemID;
    private final Long solarSystemNameID;
    private final Double luminosity;
    private final Double[] center;
    private final Double[] max;
    private final Double[] min;
    private final Double radius;
    private final Map<Long, Planet> planets;
    private final Star star;
    private final SecondaryStar secondarySun;
    private final Map<Long, Stargate> stargates;
    private final Long factionID;
    private final Long sunTypeID;
    private final Long wormholeClassID;
    private final Long descriptionID;
    private final Long[] disallowedAnchorCategories;
    private final Long[] disallowedAnchorGroups;
    private final String visualEffect;

    @JsonPOJOBuilder(withPrefix = "")
    public static class SolarSystemBuilder {

    }
}
