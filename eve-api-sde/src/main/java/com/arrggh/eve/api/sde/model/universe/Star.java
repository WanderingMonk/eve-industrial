package com.arrggh.eve.api.sde.model.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Star.StarBuilder.class)
public class Star {
    private final Long id;
    private final Long radius;
    private final StarStatistics statistics;
    private final Long typeID;

    @JsonPOJOBuilder(withPrefix = "")
    public static class StarBuilder {
    }
}
