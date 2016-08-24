package com.arrggh.eve.utilities;

/**
 * A set of utility methods that extend the standard java language.
 */
public interface LanguageUtilities {
    /**
     * Return true if the supplied object is null.
     *
     * @param value
     * @return true if value is null
     */
    static boolean isNull(Object value) {
        return value == null;
    }

    /**
     * Return true if the supplied object is <b>not</b> null.
     *
     * @param value
     * @return true if value is not null
     */
    static boolean isNotNull(Object value) {
        return not(isNull(value));
    }

    /**
     * Returns the negation of the supplied flag.
     * <p>
     * Bascially this method helps remove the bugs caused when I miss the <b>!</b> character in an conditional statement
     * when I am reading the code looking for a bug. A three letter word <b>not</b> just helps me express the intent of
     * a statement clearer.`
     *
     * @param flag
     * @return the negation of the flag value
     */
    static boolean not(boolean flag) {
        return !flag;
    }
}
