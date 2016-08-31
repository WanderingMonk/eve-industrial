package com.arrggh.eve.api.crest.parsers;


import com.arrggh.eve.api.crest.responses.eve.CrestApiMarketHistory;
import com.arrggh.eve.api.crest.responses.eve.CrestApiMarketOrders;
import com.arrggh.eve.utilities.exceptions.ParserException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public interface ResponseParsers {
    static CrestApiMarketOrders parseMarketOrders(String text) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(text, CrestApiMarketOrders.class);
        } catch (IOException e) {
            throw new ParserException("Cannot parse CrestApiMarketOrders", e);
        }
    }

    static CrestApiMarketHistory parseMarketHistory(String text) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(text, CrestApiMarketHistory.class);
        } catch (IOException e) {
            throw new ParserException("Cannot parse CrestApiMarketHistory", e);
        }
    }
}
