package com.arrggh.eve.api.sde.model.industry;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = BlueprintActivities.BlueprintActivitiesBuilder.class)
public class BlueprintActivities {
    private final BlueprintActivityCopying copying;
    private final BlueprintActivityManufacturing manufacturing;
    private final BlueprintResearch research_material;
    private final BlueprintResearch research_time;
    private final BlueprintInvention invention;

    @JsonPOJOBuilder(withPrefix = "")
    public static class BlueprintActivitiesBuilder {
    }
}
