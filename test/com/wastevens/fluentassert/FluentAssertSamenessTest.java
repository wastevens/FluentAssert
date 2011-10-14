package com.wastevens.fluentassert;

import static com.wastevens.fluentassert.FluentAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.wastevens.fluentassert.exception.ExpectedNotSameButWereSameException;
import com.wastevens.fluentassert.exception.ExpectedSameButWereNotException;
import com.wastevens.fluentassert.exception.IncompleteExpressionException;

public class FluentAssertSamenessTest {


    @Test
    public void shouldThrowExceptionWhenNoAssertionActionSet() {
        Object object = new Object();
        try {
            assertThat().expected(object).actual(object).verify();
            fail("Expected exception");
        } catch(IncompleteExpressionException exception) {
            //TODO: Revisit this once FluentAssertion isValueEqual() is written
            assertEquals(new IncompleteExpressionException("No assertion specified").getMessage(), exception.getMessage());
        }
    }    
    
    @Test
    public void shouldAssertSamesnessForSameObject() {
        Object object = new Object();
        
        assertThat().expected(object).isTheSameAs().actual(object).verify();
    }

    @Test
    public void shouldThrowExceptionWhenAssertingSamenessOnNotSameObjects() {
        Object expected = new Object();
        Object actual = new Object();
        try {
            assertThat().expected(expected).isTheSameAs().actual(actual).verify();
            fail("Expected exception");
        } catch(ExpectedSameButWereNotException exception) {
            //TODO: Revisit this once FluentAssertion isValueEqual() is written
            assertEquals(new ExpectedSameButWereNotException(expected, actual).getMessage(), exception.getMessage());
        }
    }

    @Test
    public void shouldAssertNotSamesnessForDistinctObjects() {
        Object expected = new Object();
        Object actual = new Object();
        
        assertThat().expected(expected).isNotTheSameAs().actual(actual).verify();
    }

    @Test
    public void shouldThrowExceptionWhenAssertingNotSamenessOnSameObjects() {
        Object object = new Object();
        try {
            assertThat().expected(object).isNotTheSameAs().actual(object).verify();
            fail("Expected exception");
        } catch(ExpectedNotSameButWereSameException exception) {
            //TODO: Revisit this once FluentAssertion isValueEqual() is written
            assertEquals(new ExpectedNotSameButWereSameException(object, object).getMessage(), exception.getMessage());
        }
    }    
    
}
