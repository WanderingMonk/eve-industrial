package com.arrggh.eve.api.sde.model.industry;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Blueprint.BlueprintBuilder.class)
public class Blueprint {
    private final BlueprintActivities activities;
    private final Long blueprintTypeID;
    private final Long maxProductionLimit;

    @JsonPOJOBuilder(withPrefix = "")
    public static class BlueprintBuilder {
    }
}
