package com.wastevens.fluentassert.exception;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpectedNotSameButWereSameExceptionTest {
    @Test
    public void shouldFormatMessageCorrectly() {
        Object expectedObject = new Object();
        Object actualObject = new Object();

        String expectedMessage = "Expected <" + ReflectionToStringBuilder.toString(expectedObject)
                + "> to not be the same as actual <" + ReflectionToStringBuilder.toString(actualObject) + ">.";

        ExpectedNotSameButWereSameException exception = new ExpectedNotSameButWereSameException(expectedObject, actualObject);

        //TODO: Refactor this with FluentAssertion once equality is done.
        assertEquals(expectedMessage, exception.getMessage());
    }
}
