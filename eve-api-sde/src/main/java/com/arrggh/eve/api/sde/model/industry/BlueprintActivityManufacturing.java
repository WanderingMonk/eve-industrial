package com.arrggh.eve.api.sde.model.industry;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = BlueprintActivityManufacturing.BlueprintActivityManufacturingBuilder.class)
public class BlueprintActivityManufacturing {
    private final BlueprintMaterial[] materials;
    private final BlueprintMaterial[] products;
    private final SkillRequired[] skills;
    private final Long time;

    @JsonPOJOBuilder(withPrefix = "")
    public static class BlueprintActivityManufacturingBuilder {
    }
}
