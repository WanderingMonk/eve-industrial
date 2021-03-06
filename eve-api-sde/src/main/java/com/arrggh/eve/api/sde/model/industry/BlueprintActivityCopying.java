package com.arrggh.eve.api.sde.model.industry;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = BlueprintActivityCopying.BlueprintActivityCopyingBuilder.class)
public class BlueprintActivityCopying {
    private final Long time;
    private final BlueprintMaterial[] materials;
    private final BlueprintMaterial[] products;
    private final SkillRequired[] skills;

    @JsonPOJOBuilder(withPrefix = "")
    public static class BlueprintActivityCopyingBuilder {
    }
}
