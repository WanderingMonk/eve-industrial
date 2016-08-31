package com.arrggh.eve.api.sde.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Graphic.GraphicBuilder.class)
public class Graphic {
    private final String description;
    private final String graphicFile;
    private final String iconFolder;
    private final String sofFactionName;
    private final String sofHullName;
    private final String sofRaceName;

    @JsonPOJOBuilder(withPrefix = "")
    public static class GraphicBuilder {
    }
}
