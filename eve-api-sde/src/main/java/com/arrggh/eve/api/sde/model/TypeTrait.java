package com.arrggh.eve.api.sde.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.util.Map;

@Value
@Builder
@JsonDeserialize(builder = TypeTrait.TypeTraitBuilder.class)
public class TypeTrait {
    private final Bonuses[] roleBonuses;
    private final Map<Object, Object> types;

    @JsonPOJOBuilder(withPrefix = "")
    public static class TypeTraitBuilder {
    }
}
