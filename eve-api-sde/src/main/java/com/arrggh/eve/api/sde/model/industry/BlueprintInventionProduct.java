package com.arrggh.eve.api.sde.model.industry;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = BlueprintInventionProduct.BlueprintInventionProductBuilder.class)
public class BlueprintInventionProduct {
    private final Long quantity;
    private final Long typeID;
    private final Double probability;

    @JsonPOJOBuilder(withPrefix = "")
    public static class BlueprintInventionProductBuilder {
    }
}

