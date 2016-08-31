package com.arrggh.eve.api.sde.model.universe;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = CelestialBodyStatistics.CelestialBodyStatisticsBuilder.class)
public class CelestialBodyStatistics {
    private final Double density;
    private final Double eccentricity;
    private final Double escapeVelocity;
    private final Boolean fragmented;
    private final Double life;
    private final Boolean locked;
    private final Double massDust;
    private final Double massGas;
    private final Double orbitPeriod;
    private final Double orbitRadius;
    private final Double pressure;
    private final Double radius;
    private final Double rotationRate;
    private final String spectralClass;
    private final Double surfaceGravity;
    private final Double temperature;

    @JsonPOJOBuilder(withPrefix = "")
    public static class CelestialBodyStatisticsBuilder {
    }
}
