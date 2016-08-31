package com.arrggh.eve.api.sde.model.industry;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = SkillRequired.SkillRequiredBuilder.class)
public class SkillRequired {
    private final Long level;
    private final Long typeID;

    @JsonPOJOBuilder(withPrefix = "")
    public static class SkillRequiredBuilder {
    }
}

