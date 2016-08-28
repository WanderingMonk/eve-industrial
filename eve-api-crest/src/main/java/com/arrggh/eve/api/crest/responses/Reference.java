package com.arrggh.eve.api.crest.responses;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Reference.ReferenceBuilder.class)
public class Reference {
    private final String id_str;
    private final String href;
    private final long id;
    private final String name;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ReferenceBuilder {
    }

}
