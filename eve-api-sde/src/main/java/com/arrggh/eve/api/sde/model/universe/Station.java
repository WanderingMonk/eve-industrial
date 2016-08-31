package com.arrggh.eve.api.sde.model.universe;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Station.StationBuilder.class)
public class Station {
    private final Long graphicID;
    private final Boolean isConquerable;
    private final Long operationID;
    private final Long ownerID;
    private final Double[] position;
    private final Double reprocessingEfficiency;
    private final Long reprocessingHangarFlag;
    private final Double reprocessingStationsTake;
    private final Long typeID;
    private final Boolean useOperationName;

    @JsonPOJOBuilder(withPrefix = "")
    public static class StationBuilder {
    }
}
