package com.arrggh.eve.api.sde.model.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Constellation.ConstellationBuilder.class)
public class Constellation {
    private final Double[] center;
    private final Double[] max;
    private final Double[] min;
    private final Double radius;
    private final Long nameID;
    private final Long factionID;
    private final Long constellationID;
    private final Long wormholeClassID;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ConstellationBuilder {

    }
}
