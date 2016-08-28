package com.arrggh.eve.utilities.queries;

import lombok.Builder;
import lombok.Value;

import java.time.Instant;

@Value
@Builder
public class CachedResponse {
    private final Instant expiryTime;
    private final String document;

    public boolean hasExpired() {
        Instant now = Instant.now();
        return now.isAfter(expiryTime);
    }
}
