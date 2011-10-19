package com.wastevens.fluentassert.exception;

import org.junit.Test;

public class FluentAssertionExceptionTest {

    @Test(expected=RuntimeException.class)
    public void shouldBeRuntimeException() {
        throw new FluentAssertionException("something went wrong");
    }
    
    
}
