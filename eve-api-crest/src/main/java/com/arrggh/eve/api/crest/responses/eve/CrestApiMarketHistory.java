package com.arrggh.eve.api.crest.responses.eve;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@JsonDeserialize(builder = CrestApiMarketHistory.CrestApiMarketHistoryBuilder.class)
public class CrestApiMarketHistory {
    private final long totalCount;
    private final String totalCount_str;
    private final long pageCount;
    private final String pageCount_str;
    private final List<CrestApiMarketDayHistory> items;

    @JsonPOJOBuilder(withPrefix = "")
    public static class CrestApiMarketHistoryBuilder {
    }
}
