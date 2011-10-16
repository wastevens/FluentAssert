package com.wastevens.fluentassert.assertions;

import com.wastevens.fluentassert.exception.ExpectedSameButWereNotException;

public class IsTheSameAs implements Assertion {

    private final Object expected;

    private IsTheSameAs(Object expected) {
        this.expected = expected;
    }
    
    @Override
    public void assertAgainst(Object actual) {
        if (expected != actual)
            throw new ExpectedSameButWereNotException(expected, actual);
    }
    
    public static IsTheSameAs isTheSameAs(Object expected) {
        return new IsTheSameAs(expected);
    }
}
