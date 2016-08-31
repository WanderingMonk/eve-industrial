package com.arrggh.eve.api.sde.model.tournaments;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = PointType.PointTypeBuilder.class)
public class PointType {
    private final Long points;
    private final Long typeID;

    @JsonPOJOBuilder(withPrefix = "")
    public static class PointTypeBuilder {
    }
}
