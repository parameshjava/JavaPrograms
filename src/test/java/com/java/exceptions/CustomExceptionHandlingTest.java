package com.java.exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.TestCase;

public class CustomExceptionHandlingTest extends TestCase {

	CustomExceptionHandling customException;
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	@Override
	public void setUp() {
		customException = new CustomExceptionHandling();
	}
	
	@Test(expected = InvalidCredentialsException.class)
	public void testPerformLoginlankUsername() {
		try {
			customException.validateLogin(null, null);
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Username should not be blank"));
		}
	}
	
	@Test(expected = InvalidCredentialsException.class)
	public void testPerformLoginBlankPassword() {
		try {
			customException.validateLogin("Rahul", null);
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Password should not be blank"));
		}
	}
	
	@Test(expected = InvalidCredentialsException.class)
	public void testPerformLoginBadUsername() {
		try {
			customException.validateLogin("Rahul", "secret");
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Username not converted as number"));
			assertTrue(e.getCause() instanceof NumberFormatException);
		}
	}
	
	@Test(expected = InvalidCredentialsException.class)
	public void testPerformLoginWrongPassword() {
		try {
			customException.validateLogin("123456", "mywish");
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Username and password not matched"));
		}
	}
	
    public void testPerformLoginSuccess() {
        boolean isSuccess = customException.validateLogin("123456", "secret");
        assertTrue(isSuccess);
    }
	
	@Override
	public void tearDown() {
		customException = null;
	}

}
