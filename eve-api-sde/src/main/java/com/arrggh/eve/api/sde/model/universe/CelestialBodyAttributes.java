package com.arrggh.eve.api.sde.model.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = CelestialBodyAttributes.CelestialBodyAttributesBuilder.class)
public class CelestialBodyAttributes {
    private final Long heightMap1;
    private final Long heightMap2;
    private final Boolean population;
    private final Long shaderPreset;

    @JsonPOJOBuilder(withPrefix = "")
    public static class CelestialBodyAttributesBuilder {
    }
}
