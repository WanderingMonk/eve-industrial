package com.arrggh.eve.api.sde.model.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = StarStatistics.StarStatisticsBuilder.class)
public class StarStatistics {
    private final Double age;
    private final Double life;
    private final Boolean locked;
    private final Double luminosity;
    private final Double radius;
    private final String spectralClass;
    private final Double temperature;

    @JsonPOJOBuilder(withPrefix = "")
    public static class StarStatisticsBuilder {
    }
}
