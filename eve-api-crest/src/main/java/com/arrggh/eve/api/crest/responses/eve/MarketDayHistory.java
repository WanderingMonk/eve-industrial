package com.arrggh.eve.api.crest.responses.eve;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = MarketDayHistory.MarketDayHistoryBuilder.class)
public class MarketDayHistory {
    private final String volume_str;
    private final long orderCount;
    private final double lowPrice;
    private final double highPrice;
    private final double avgPrice;
    private final long volume;
    private final String orderCount_str;
    private final String date;

    @JsonPOJOBuilder(withPrefix = "")
    public static class MarketDayHistoryBuilder {
    }
}
