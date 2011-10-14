package com.wastevens.fluentassert.exception;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;

public class ExpectedSameButWereNotExceptionTest {

    @Test
    public void shouldFormatMessageCorrectly() {
        Object expectedObject = new Object();
        Object actualObject = new Object();

        String expectedMessage = "Expected <" + ReflectionToStringBuilder.toString(expectedObject)
                + "> to be the same as actual <" + ReflectionToStringBuilder.toString(actualObject) + ">.";
        
        ExpectedSameButWereNotException exception = new ExpectedSameButWereNotException(expectedObject, actualObject);
        
        //TODO: Refactor this with FluentAssertion once equality is done.
        assertEquals(expectedMessage, exception.getMessage());
    }

}
