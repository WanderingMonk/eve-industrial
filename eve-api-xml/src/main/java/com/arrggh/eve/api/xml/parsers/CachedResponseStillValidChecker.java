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

public class CachedResponseStillValidChecker implements Function<String, Boolean> {
    private static final Logger LOG = LoggerFactory.getLogger(CachedResponseStillValidChecker.class);

    @Override
    public Boolean apply(String text) {
        try {
            SAXBuilder jdomBuilder = new SAXBuilder();
            Document document = jdomBuilder.build(new StringReader(text));
            Element cachedUntil = document.getRootElement().getChild("result").getChild("cachedUntil");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime cachedTime = LocalDateTime.parse(cachedUntil.getTextNormalize(), formatter);
            Instant cachedTimeInstant = cachedTime.toInstant(ZoneOffset.UTC);
            Instant nowInstant = Clock.systemUTC().instant();

            if (nowInstant.compareTo(cachedTimeInstant) < 0) {
                LOG.info("Use cached file, cached time '{}' is ahead of '{}'", cachedTimeInstant, nowInstant);
                return true;
            }
            LOG.info("Cached file expired, cached time '{}' is behind '{}'", cachedTimeInstant, nowInstant);
            return false;
        } catch (JDOMException | IOException e) {
            LOG.error("Problem parsing XML file", e);
        }
        return true;
    }
}
