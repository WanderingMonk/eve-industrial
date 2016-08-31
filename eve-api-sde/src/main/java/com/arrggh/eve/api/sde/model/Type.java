package com.arrggh.eve.api.sde.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.Map;

@Value
@Builder
@JsonDeserialize(builder = Type.TypeBuilder.class)
public class Type {
    private final long groupID;
    private final long iconID;
    private final double basePrice;
    private final double capacity;
    private final long portionSize;
    private final long raceID;
    private final long marketGroupID;
    private final long factionID;
    private final long graphicID;
    private final long soundID;
    private final String sofFactionName;
    private final TranslatedString name;
    private final TranslatedString description;
    private final boolean published;
    private final double mass;
    private final double radius;
    private final double volume;
    private final Map<Long, List<Long>> masteries;
    private final TypeTrait traits;

    @JsonPOJOBuilder(withPrefix = "")
    public static class TypeBuilder {
    }
}
