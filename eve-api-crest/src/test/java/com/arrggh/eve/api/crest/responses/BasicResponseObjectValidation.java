package com.arrggh.eve.api.crest.responses;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static com.arrggh.eve.utilities.StringUtilities.isValid;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public abstract class BasicResponseObjectValidation<T> {

    protected abstract Class<T> getClassUnderTest();

    protected abstract T getObjectUnderTest();

    @Test
    public void testToString() {
        T t = getObjectUnderTest();
        assertNotNull(t);
        String toString = t.toString();
        assertNotNull(toString);
        assertTrue(isValid(toString));
    }

    @Test
    public void testHashCodeAndEquals() {
        EqualsVerifier.forClass(getClassUnderTest()).verify();
    }
}
