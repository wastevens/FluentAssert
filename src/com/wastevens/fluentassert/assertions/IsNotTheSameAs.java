package com.wastevens.fluentassert.assertions;

import com.wastevens.fluentassert.exception.ExpectedNotSameButWereSameException;

public class IsNotTheSameAs implements Assertion {

    private final Object expected;

    private IsNotTheSameAs(Object expected) {
        this.expected = expected;
    }
    
    @Override
    public void assertAgainst(Object actual) {
        if (expected == actual)
            throw new ExpectedNotSameButWereSameException(actual, expected);
    }
    
    public static IsNotTheSameAs isNotTheSameAs(Object expected) {
        return new IsNotTheSameAs(expected);
    }
}
