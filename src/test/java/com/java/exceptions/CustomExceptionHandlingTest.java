package com.java.exceptions;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CustomExceptionHandlingTest {

    CustomExceptionHandling customException;

    @Before
    public void setUp() {
        customException = new CustomExceptionHandling();
    }

    @Test
    public void testPerformLoginlankUsername() {
        try {
            customException.validateLogin(null, null);
        } catch (InvalidCredentialsException e) {
            assertTrue(e.getMessage().equals("Username should not be blank"));
        }
    }

    @Test
    public void testPerformLoginBlankPassword() {
        try {
            customException.validateLogin("Rahul", null);
        } catch (InvalidCredentialsException e) {
            assertTrue(e.getMessage().equals("Password should not be blank"));
        }
    }

    @Test
    public void testPerformLoginBadUsername() {
        try {
            customException.validateLogin("Rahul", "secret");
        } catch (InvalidCredentialsException e) {
            //Assert.assertTrue(e.getMessage().equals("Username not converted as number"));
            assertEquals("Username not converted as number", e.getMessage());
            assertTrue(e.getCause() instanceof NumberFormatException);
        }
    }

    @Test
    public void testPerformLoginWrongPassword() {
        try {
            customException.validateLogin("123456", "mywish");
        } catch (InvalidCredentialsException e) {
            assertTrue(e.getMessage().equals("Username and password not matched"));
        }
    }

    @Test
    public void testPerformLoginSuccess() {
        boolean isSuccess = customException.validateLogin("123456", "secret");
        assertTrue(isSuccess);
    }

    @After
    public void tearDown() {
        customException = null;
    }

}
