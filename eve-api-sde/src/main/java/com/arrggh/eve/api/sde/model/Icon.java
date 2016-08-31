package com.arrggh.eve.api.sde.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Icon.IconBuilder.class)
public class Icon {
    private final String description;
    private final String iconFile;

    @JsonPOJOBuilder(withPrefix = "")
    public static class IconBuilder {
    }
}
