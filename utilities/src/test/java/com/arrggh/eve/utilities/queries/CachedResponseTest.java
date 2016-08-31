package com.arrggh.eve.utilities.queries;

import com.arrggh.eve.utilities.queries.CachedResponse;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import java.time.Instant;
import java.time.Period;

import static org.junit.Assert.*;

public class CachedResponseTest {
    @Test
    public void testExpiryTime() {
        Instant now = Instant.now();
        Instant lastWeek = now.minus(Period.ofDays(7));
        Instant nextWeek = now.minus(Period.ofDays(7));

        CachedResponse lastWeekResponse = CachedResponse.builder().expiryTime(lastWeek).document("old").build();
        CachedResponse nextWeekResponse = CachedResponse.builder().expiryTime(nextWeek).document("old").build();

        assertTrue(lastWeekResponse.hasExpired());
        assertTrue(nextWeekResponse.hasExpired());
    }

    @Test
    public void testHashcodeAndEquals() {
        EqualsVerifier.forClass(CachedResponse.class).verify();
    }
}