package com.java.exceptions;

/**
 * This class demonstrate how to perform user defined exception handling <br>
 * <b>Problem description:</b> Throw Module specific exception i.e., {@link InvalidCredentialsException} to identify quickly related to Login functionality errors.<br>
 * This user defined exception should match with the following criteria.<br>
 * 1. When user key in blank in username field:<br>&nbsp;&nbsp;
 * Throw exception along with the message to convey as username should not be blank.<br>
 * 2. When user key in blank in password field:<br>&nbsp;&nbsp;
 * Throw exception along with the message to convey as password should not be blank.<br>
 * 3. When user key in non numeric string in username field:<br>&nbsp;&nbsp;
 * Throw exception along with the actual root cause {@link NumberFormatException}.<br>
 * 4. When user name and password not matched with the criteria:<br>&nbsp;&nbsp;
 * Throw exception along with the message to convey as username and password are incorrect.
 * 
 * @author Paramesh
 *
 */
public class CustomExceptionHandling {

    /**
     * Performs authentication mechanism
     * 
     * @param username
     *            user name of the client
     * @param password
     *            password of the client
     * @return ture if authentication success, otherwise false
     * @throws InvalidCredentialsException
     *             when client provided invalid input
     */
    public boolean validateLogin(String username, String password) throws InvalidCredentialsException {
        // 1. Throw user defined exception when user key in blank in username field
        if (username == null) {
            throw new InvalidCredentialsException("Username should not be blank");
        }

        // 2. Throw user defined exception when user key in blank in password field
        if (password == null) {
            throw new InvalidCredentialsException("Password should not be blank");
        }

        try {
            // Try to convert given string to Integer format
            int number = Integer.parseInt(username);
            // Login successful when user key in username as number format convertible and password is secret
            if (number > 0 && password.equals("secret")) {
                return true;
            } else {
                // 4. Throw user defined exception when given inputs are not matched with the criteria
                throw new InvalidCredentialsException("Username and password not matched");
            }
        } catch (NumberFormatException exp) {
            // 3. Throw user defined exception along with the actual cause when given username not able to convert as number
            throw new InvalidCredentialsException("Username not converted as number", exp);
        }
    }
    
}
