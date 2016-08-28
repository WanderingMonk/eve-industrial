package com.arrggh.eve.api.crest.responses.eve;

import com.arrggh.eve.api.crest.responses.Reference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = MarketOrder.MarketOrderBuilder.class)
public class MarketOrder {
    private final long id;
    private final String id_str;
    private final boolean buy;
    private final String issued;
    private final String range;
    private final String href;
    private final double price;
    private final long volumeEntered;
    private final String volumeEntered_str;
    private final long minVolume;
    private final String minVolume_str;
    private final long volume;
    private final String volume_str;
    private final long duration;
    private final String duration_str;
    private final Reference type;
    private final Reference location;

    @JsonPOJOBuilder(withPrefix = "")
    public static class MarketOrderBuilder {
    }
}
