package com.wastevens.fluentassert;

import static com.wastevens.fluentassert.FluentAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.wastevens.fluentassert.assertions.Assertion;
import com.wastevens.fluentassert.exception.FluentAssertionException;
import com.wastevens.fluentassert.exception.IncompleteExpressionException;

public class FluentAssertTest {

    @Test
    public void shouldThrowExceptionWhenNoAssertionCriteriaSet() {
        Object object = new Object();
        try {
            assertThat(object);
            fail("Expected exception");
        } catch(IncompleteExpressionException exception) {
            //TODO: Revisit this once FluentAssertion isValueEqual() is written
            assertEquals(new IncompleteExpressionException("No assertion specified").getMessage(), exception.getMessage());
        }
    }
    
    @Test
    public void shouldExecuteAllGivenAssertionsAgainstGivenObject() {
        Object actual = new Object();
        Assertion anAssertion = mock(Assertion.class);
        Assertion anotherAssertion = mock(Assertion.class);
        Assertion yetAnotherAssertion = mock(Assertion.class);
        
        assertThat(actual, anAssertion, anotherAssertion, yetAnotherAssertion);

        verify(anAssertion).assertAgainst(actual);
        verify(anotherAssertion).assertAgainst(actual);
        verify(yetAnotherAssertion).assertAgainst(actual);
    }
    
    @Test
    public void shouldExecuteAssertionsOnlyUntilOneFails() {
        Object actual = new Object();
        Assertion anAssertion = mock(Assertion.class);
        Assertion anotherAssertion = mock(Assertion.class);
        Assertion yetAnotherAssertion = mock(Assertion.class);
        
        FluentAssertionException fluentAssertionException = new FluentAssertionException("mock exception");
        doThrow(fluentAssertionException).when(anotherAssertion).assertAgainst(actual);
        
        try {
            assertThat(actual, anAssertion, anotherAssertion, yetAnotherAssertion);
            fail("Expected exception");
        } catch(FluentAssertionException exception) {
            assertEquals(exception, fluentAssertionException);
        }

        verify(anAssertion).assertAgainst(actual);
        verify(anotherAssertion).assertAgainst(actual);
        verify(yetAnotherAssertion, never()).assertAgainst(actual);
    }
}
