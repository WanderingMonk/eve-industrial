package com.arrggh.eve.api.sde.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Category.CategoryBuilder.class)
public class Category {
    private final TranslatedString name;
    private final Boolean published;
    private final Long iconID;

    @JsonPOJOBuilder(withPrefix = "")
    public static class CategoryBuilder {
    }
}
