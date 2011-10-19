package com.wastevens.fluentassert.exception;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@SuppressWarnings("serial")
public class ExpectedNotSameButWereSameException extends FluentAssertionException {

    public ExpectedNotSameButWereSameException(Object expected, Object actual) {
        super("Expected <" + ReflectionToStringBuilder.toString(expected) + "> to not be the same as actual <"
                + ReflectionToStringBuilder.toString(actual) + ">.");
    }

}
