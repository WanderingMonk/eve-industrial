package com.arrggh.eve.api.sde.model.tournaments;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = GroupType.GroupTypeBuilder.class)
public class GroupType {
    private final Long points;
    private final Long groupID;

    @JsonPOJOBuilder(withPrefix = "")
    public static class GroupTypeBuilder {
    }
}
