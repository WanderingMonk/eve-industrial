package com.arrggh.eve.api.crest.parsers;


import com.arrggh.eve.api.crest.responses.eve.MarketHistory;
import com.arrggh.eve.api.crest.responses.eve.MarketOrders;
import com.arrggh.eve.utilities.exceptions.ParserException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public interface ResponseParsers {
    static MarketOrders parseMarketOrders(String text) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(text, MarketOrders.class);
        } catch (IOException e) {
            throw new ParserException("Cannot parse MarketOrders", e);
        }
    }

    static MarketHistory parseMarketHistory(String text) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(text, MarketHistory.class);
        } catch (IOException e) {
            throw new ParserException("Cannot parse MarketHistory", e);
        }
    }
}
