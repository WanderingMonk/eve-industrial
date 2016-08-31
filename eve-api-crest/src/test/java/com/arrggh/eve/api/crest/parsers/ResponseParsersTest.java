package com.arrggh.eve.api.crest.parsers;

import com.arrggh.eve.api.crest.responses.eve.CrestApiMarketHistory;
import com.arrggh.eve.api.crest.responses.eve.CrestApiMarketOrders;
import com.arrggh.eve.utilities.exceptions.ParserException;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ResponseParsersTest {
    private String getFileContents(Class<?> base, String file) throws IOException {
        String contents = IOUtils.toString(base.getResourceAsStream(file), "utf-8");
        Assert.assertTrue(contents.length() > 0);
        return contents;
    }

    private String getValidFileContents(Class<?> base, String file) throws IOException {
        return getFileContents(base, file);
    }

    private String getInvalidFileContents(Class<?> base, String file) throws IOException {
        return getFileContents(base, file).substring(40);
    }

    @Test
    public void testParseMarketOrdersValid() throws Exception {
        assertEquals(82, ResponseParsers.parseMarketOrders(getValidFileContents(CrestApiMarketOrders.class, "market-orders.json")).getItems().size());
    }

    @Test(expected = ParserException.class)
    public void testParseMarketOrdersInvalid() throws Exception {
        ResponseParsers.parseMarketOrders(getInvalidFileContents(CrestApiMarketOrders.class, "market-orders.json"));
    }

    @Test
    public void testParseMarketHistoryValid() throws Exception {
        assertEquals(420, ResponseParsers.parseMarketHistory(getValidFileContents(CrestApiMarketHistory.class, "market-history.json")).getItems().size());
    }

    @Test(expected = ParserException.class)
    public void testParseMarketHistoryInvalid() throws Exception {
        ResponseParsers.parseMarketHistory(getInvalidFileContents(CrestApiMarketHistory.class, "market-history.json"));
    }

}