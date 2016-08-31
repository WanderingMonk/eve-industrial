package com.arrggh.eve.api.sde.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Bonuses.BonusesBuilder.class)
public class Bonuses {
    private final double bonus;
    private final TranslatedString bonusText;
    private final long importance;
    private final long unitID;

    @JsonPOJOBuilder(withPrefix = "")
    public static class BonusesBuilder {
    }
}
