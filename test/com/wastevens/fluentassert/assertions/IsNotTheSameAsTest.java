package com.wastevens.fluentassert.assertions;

import static com.wastevens.fluentassert.assertions.IsNotTheSameAs.isNotTheSameAs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.wastevens.fluentassert.exception.ExpectedNotSameButWereSameException;

public class IsNotTheSameAsTest {

    @Test
    public void shouldDoNothingWhenPerformingSamenessAssertOnTwoSameObjects() {
        Object actual = new Object();
        Object expected = actual;
        
        verifyProperExceptionThrown(expected, actual);
    }
    
    @Test
    public void shouldThrowExpectedNotSameButWereSameExceptionWhenGivenTwoNulls() {
        Object actual = null;
        Object expected = null;
        
        verifyProperExceptionThrown(expected, actual);
    }
    
    @Test
    public void shouldDoNothingnWhenGivenTwoDistinctObjects() {
        Object actual = new Object();
        Object expected = new Object();
        
        isNotTheSameAs(expected).assertAgainst(actual);
    }
    
    @Test
    public void shouldDoNothingWhenGivenNullForActualAndAnObjectWasExpected() {
        Object nullActual = null;
        Object expected = new Object();
        
        isNotTheSameAs(expected).assertAgainst(nullActual);
    }
    
    @Test
    public void shouldDoNothingWhenGivenNullForExpectedAndAnObjectWasActual() {
        Object actual = new Object();
        Object nullExpected = null;
        
        isNotTheSameAs(nullExpected).assertAgainst(actual);
    }
    
    private void verifyProperExceptionThrown(Object expected, Object actual) {
        try {
            isNotTheSameAs(expected).assertAgainst(actual);
            fail("Expected exception");
        } catch(ExpectedNotSameButWereSameException exception) {
            //TODO: Revisit this once FluentAssertion isValueEqual() is written
            assertEquals(new ExpectedNotSameButWereSameException(expected, actual).getMessage(), exception.getMessage());
        }        
    }
    
}
