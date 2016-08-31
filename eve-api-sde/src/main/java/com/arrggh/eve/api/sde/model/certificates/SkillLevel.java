package com.arrggh.eve.api.sde.model.certificates;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = SkillLevel.SkillLevelBuilder.class)
public class SkillLevel {
    private final Long basic;
    private final Long standard;
    private final Long improved;
    private final Long advanced;
    private final Long elite;

    @JsonPOJOBuilder(withPrefix = "")
    public static class SkillLevelBuilder {
    }
}
