package com.wastevens.fluentassert.assertions;

import static com.wastevens.fluentassert.assertions.IsTheSameAs.isTheSameAs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.wastevens.fluentassert.exception.ExpectedSameButWereNotException;

public class IsTheSameAsTest {

    @Test
    public void shouldDoNothingWhenPerformingSamenessAssertOnTwoSameObjects() {
        Object actual = new Object();
        Object expected = actual;
        isTheSameAs(expected).assertAgainst(actual);
    }
    
    @Test
    public void shouldDoNothingWhenPerformingSamenessAssertOnTwoNulls() {
        isTheSameAs(null).assertAgainst(null);
    } 
    
    @Test
    public void shouldThrowExpectedSameButWereNotExceptionWhenGivenTwoDistinctObjects() {
        Object expected = new Object();
        Object actual = new Object();
        
        verifyProperExceptionThrown(expected, actual);
    }
       
    @Test
    public void shouldThrowExpectedSameButWereNotExceptionWhenGivenNullForActualAndAnObjectWasExpected() {
        Object expected = new Object();
        Object nullActual = null;
        
        verifyProperExceptionThrown(expected, nullActual);
    }
    
    @Test
    public void shouldThrowExpectedSameButWereNotExceptionWhenGivenNullForExpectedAndAnObjectWasActual() {
        Object nullExpected = null;
        Object actual = new Object();
        
        verifyProperExceptionThrown(nullExpected, actual);
    }
    
    private void verifyProperExceptionThrown(Object expected, Object actual) {
        try {
            isTheSameAs(expected).assertAgainst(actual);
            fail("Expected exception");
        } catch(ExpectedSameButWereNotException exception) {
            //TODO: Revisit this once FluentAssertion isValueEqual() is written
            assertEquals(new ExpectedSameButWereNotException(expected, actual).getMessage(), exception.getMessage());
        }        
    }
}
