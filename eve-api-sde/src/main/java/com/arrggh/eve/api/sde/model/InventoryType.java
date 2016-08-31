package com.arrggh.eve.api.sde.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = InventoryType.InventoryTypeBuilder.class)
public class InventoryType {

    @JsonPOJOBuilder(withPrefix = "")
    public static class InventoryTypeBuilder {

    }
}
