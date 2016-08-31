package com.arrggh.eve.api.sde.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static com.arrggh.eve.utilities.StringUtilities.isValid;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public abstract class BasicModelObjectValidation<T> {
    protected abstract Class<T> getClassUnderTest();

    protected  abstract T getInstanceUnderTest();

    @Test
    public void testToString() {
        T t = getInstanceUnderTest();
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
