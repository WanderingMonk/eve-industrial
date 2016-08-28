package com.arrggh.eve.api.crest.parsers;

import java.time.Instant;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.util.function.Function;

public class CrestExpiryTimeCalculator implements Function<String, Instant> {
    private final TemporalAmount timeout;

    public CrestExpiryTimeCalculator(TemporalAmount timeout) {
        this.timeout = timeout;
    }

    @Override
    public Instant apply(String s) {
        return Instant.now().plus(timeout);
    }
}
