package com.wastevens.fluentassert.assertions;

import com.wastevens.fluentassert.exception.ExpectedNotSameButWereSameException;
import com.wastevens.fluentassert.exception.ExpectedSameButWereNotException;

public class IsTheSameAs implements Assertion {

    private final Object expected;
    
    private Boolean notTheSameAs = false;

    private IsTheSameAs(Object expected) {
        this.expected = expected;
    }

    public IsTheSameAs not() {
        this.notTheSameAs = true;
        return this;
    }
    
    public static IsTheSameAs isTheSameAs(Object expected) {
        return new IsTheSameAs(expected);
    }
    
    @Override
    public void assertAgainst(Object actual) {
        if (!notTheSameAs)
            assertExpectedIsTheSameAs(actual);
        else
            assertExpectedIsNotTheSameAs(actual);
    }

    private void assertExpectedIsTheSameAs(Object actual) {
        if (expected != actual)
            throw new ExpectedSameButWereNotException(expected, actual);
    }
    
    private void assertExpectedIsNotTheSameAs(Object actual) {
        if (expected == actual)
            throw new ExpectedNotSameButWereSameException(expected, actual);
    }
}
