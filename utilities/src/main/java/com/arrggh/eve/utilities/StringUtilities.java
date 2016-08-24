package com.arrggh.eve.utilities;

import static com.arrggh.eve.utilities.LanguageUtilities.isNull;
import static com.arrggh.eve.utilities.LanguageUtilities.not;

/**
 * A set of helper methods to extend the string operations to make working with strings easier.
 */
public interface StringUtilities {
    /**
     * Returns true if the string is null or empty.
     *
     * The string is considered null is the value is null obviously. The supplied string is considered empty if the
     * trimmed length of the string is zero (using the isEmpty()) method.
     *
     * @param value
     * @return true if the string is null or empty
     */
    static boolean isEmptyOrNull(String value) {
        return isNull(value) || value.trim().isEmpty();
    }

    /**
     * Returns true if the string is <b>not</b> null and <b>not</b> empty.
     *
     * The string is considered valid if the string contains some non-whitespace characters.
     *
     * @param value
     * @return true if the string is valid
     */
    static boolean isValid(String value) {
        return not(isEmptyOrNull(value));
    }
}
