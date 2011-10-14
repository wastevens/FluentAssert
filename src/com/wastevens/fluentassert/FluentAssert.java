package com.wastevens.fluentassert;

import com.wastevens.fluentassert.exception.ExpectedNotSameButWereSameException;
import com.wastevens.fluentassert.exception.ExpectedSameButWereNotException;
import com.wastevens.fluentassert.exception.IncompleteExpressionException;

public class FluentAssert {

    private Object expected;
    private Object actual;
    private Assertion assertion;

    public static FluentAssert assertThat() {
        return new FluentAssert();
    }
    
    public FluentAssert expected(Object expected) {
        this.expected = expected;
        return this;
    }
    
    public FluentAssert actual(Object actual) {
        this.actual = actual;
        return this;
    }
    
    public FluentAssert isTheSameAs() {
        this.assertion = Assertion.IS_SAME;
        return this;
    }
    
    public FluentAssert isNotTheSameAs() {
        this.assertion = Assertion.IS_NOT_SAME;
        return this;
    }

    public void verify() {
        validateAssertionCriteria();
        
        switch (assertion) {
        case IS_SAME:
            if (expected != actual)
                throw new ExpectedSameButWereNotException(expected, actual);
            break;
        
        case IS_NOT_SAME:
            if (expected == actual)
                throw new ExpectedNotSameButWereSameException(expected, actual);            
            break;
        }
    }

    private void validateAssertionCriteria() {
        if (assertion == null) {
            throw new IncompleteExpressionException("No assertion specified");
        }
    }
}
