package com.arrggh.eve.api.sde.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Group.GroupBuilder.class)
public class Group {
    private final Boolean anchorable;
    private final Boolean anchored;
    private final Long categoryID;
    private final Long iconID;
    private final Boolean fittableNonSingleton;
    private final TranslatedString name;
    private final Boolean published;
    private final Boolean useBasePrice;

    @JsonPOJOBuilder(withPrefix = "")
    public static class GroupBuilder {
    }
}
