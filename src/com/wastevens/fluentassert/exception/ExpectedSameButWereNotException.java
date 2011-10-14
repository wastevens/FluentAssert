package com.wastevens.fluentassert.exception;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@SuppressWarnings("serial")
public class ExpectedSameButWereNotException extends FluentAssertionException {

    public ExpectedSameButWereNotException(Object expected, Object actual) {
        super("Expected <" + ReflectionToStringBuilder.toString(expected) + "> to be the same as actual <"
                + ReflectionToStringBuilder.toString(actual) + ">.");
    }

}
