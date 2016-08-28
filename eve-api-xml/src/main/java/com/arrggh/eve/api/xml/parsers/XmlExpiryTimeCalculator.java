package com.arrggh.eve.api.xml.parsers;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringReader;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public class XmlExpiryTimeCalculator implements Function<String, Instant> {
    private static final Logger LOG = LoggerFactory.getLogger(XmlExpiryTimeCalculator.class);

    @Override
    public Instant apply(String text) {
        try {
            SAXBuilder jdomBuilder = new SAXBuilder();
            Document document = jdomBuilder.build(new StringReader(text));
            Element cachedUntil = document.getRootElement().getChild("result").getChild("cachedUntil");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime cachedTime = LocalDateTime.parse(cachedUntil.getTextNormalize(), formatter);
            return cachedTime.toInstant(ZoneOffset.UTC);
        } catch (JDOMException | IOException e) {
            LOG.error("Problem parsing XML file", e);
        }
        return Instant.now();
    }
}
