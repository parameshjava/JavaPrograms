package com.java.exceptions;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.exceptions.ExceptionHandling;

public class ExceptionHandlingTest {

	@Test
	public void testSummation() {
		int sum1 = ExceptionHandling.summation("10", "15", "20");
		int sum2 = ExceptionHandling.summation("10", "15", "20", "abc");
		// Exception should be handled in the 2nd method call and sum1 & sum2
		// should produce same result
		assertEquals(sum1, sum2);
	}

}
