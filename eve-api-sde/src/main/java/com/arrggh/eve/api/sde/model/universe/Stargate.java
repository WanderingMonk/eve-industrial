package com.arrggh.eve.api.sde.model.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Stargate.StargateBuilder.class)
public class Stargate {
    private final Long destination;
    private final Double[] position;
    private final Long typeID;

    @JsonPOJOBuilder(withPrefix = "")
    public static class StargateBuilder {
    }
}
