package com.wastevens.fluentassert;

import com.wastevens.fluentassert.assertions.Assertion;
import com.wastevens.fluentassert.exception.IncompleteExpressionException;

public class FluentAssert {

    public static void assertThat(Object actual, Assertion... assertions) {
        if (assertions.length == 0)
            throw new IncompleteExpressionException("No assertion specified");
        
        for(Assertion assertion : assertions)
            assertion.assertAgainst(actual);
    }
}
