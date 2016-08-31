package com.arrggh.eve.api.sde.model.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = SecondaryStar.SecondaryStarBuilder.class)
public class SecondaryStar {
    private final Long typeID;
    private final Long effectBeaconTypeID;
    private final Long itemID;
    private final Double[] position;

    @JsonPOJOBuilder(withPrefix = "")
    public static class SecondaryStarBuilder {
    }
}
