package com.wastevens.fluentassert.assertions;

import static com.wastevens.fluentassert.assertions.IsTheSameAs.isTheSameAs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.wastevens.fluentassert.exception.ExpectedNotSameButWereSameException;
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
        
        verifyProperExceptionThrownForExpectedSameButWereNot(expected, actual);
    }
       
    @Test
    public void shouldThrowExpectedSameButWereNotExceptionWhenGivenNullForActualAndAnObjectWasExpected() {
        Object expected = new Object();
        Object nullActual = null;
        
        verifyProperExceptionThrownForExpectedSameButWereNot(expected, nullActual);
    }
    
    @Test
    public void shouldThrowExpectedSameButWereNotExceptionWhenGivenNullForExpectedAndAnObjectWasActual() {
        Object nullExpected = null;
        Object actual = new Object();
        
        verifyProperExceptionThrownForExpectedSameButWereNot(nullExpected, actual);
    }
 
    private void verifyProperExceptionThrownForExpectedSameButWereNot(Object expected, Object actual) {
        try {
            isTheSameAs(expected).assertAgainst(actual);
            fail("Expected exception");
        } catch(ExpectedSameButWereNotException exception) {
            //TODO: Revisit this once FluentAssertion isValueEqual() is written
            assertEquals(new ExpectedSameButWereNotException(expected, actual).getMessage(), exception.getMessage());
        }        
    }
    
    // not cases
    
    @Test
    public void shouldThrowExceptionExpectedNotSameButWereSameOnTwoSameObjects() {
        Object actual = new Object();
        Object expected = actual;
        
        verifyProperExceptionThrownForExpectedNotSameButWereSame(expected, actual);
    }
    
    @Test
    public void shouldThrowExceptionExpectedNotSameButWereSameWhenGivenTwoNulls() {
        Object actual = null;
        Object expected = null;
        
        verifyProperExceptionThrownForExpectedNotSameButWereSame(expected, actual);
    }
    
    @Test
    public void shouldDoNothingnWhenGivenTwoDistinctObjects() {
        Object actual = new Object();
        Object expected = new Object();
        
        isTheSameAs(expected).not().assertAgainst(actual);
    }
    
    @Test
    public void shouldDoNothingWhenGivenNullForActualAndAnObjectWasExpected() {
        Object nullActual = null;
        Object expected = new Object();
        
        isTheSameAs(expected).not().assertAgainst(nullActual);
    }
    
    @Test
    public void shouldDoNothingWhenGivenNullForExpectedAndAnObjectWasActual() {
        Object actual = new Object();
        Object nullExpected = null;
        
        isTheSameAs(nullExpected).not().assertAgainst(actual);
    }
    
    private void verifyProperExceptionThrownForExpectedNotSameButWereSame(Object expected, Object actual) {
        try {
            isTheSameAs(expected).not().assertAgainst(actual);
            fail("Expected exception");
        } catch(ExpectedNotSameButWereSameException exception) {
            //TODO: Revisit this once FluentAssertion isValueEqual() is written
            assertEquals(new ExpectedNotSameButWereSameException(expected, actual).getMessage(), exception.getMessage());
        }        
    }    
}
