package com.arrggh.eve.api.sde.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = TranslatedString.TranslatedStringBuilder.class)
public class TranslatedString {
    private final String de;
    private final String en;
    private final String es;
    private final String fr;
    private final String it;
    private final String ja;
    private final String ru;
    private final String zh;

    @JsonPOJOBuilder(withPrefix = "")
    public static class TranslatedStringBuilder {

    }
}
