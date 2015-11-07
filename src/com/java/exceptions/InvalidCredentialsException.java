package com.java.exceptions;

/**
 * Exception class to file when user key in wrong credentials into the syste to
 * login
 * 
 * @author Paramesh
 *
 */
public class InvalidCredentialsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * To just throw user defined exception object
	 */
	public InvalidCredentialsException() {
		super();
	}

	/**
	 * To throw user defined exception along with brief description of the exception.
	 * 
	 * @param message
	 *            brief description about the cause of exception
	 */
	public InvalidCredentialsException(String message) {
		super(message);
	}

	/**
	 * To throw user defined exception along with brief description and actual
	 * root cause of the exception. <br />
	 * Here, Throwable object helps the programmer to know actual cause of exception.
	 * 
	 * @param message
	 *            Brief description about the cause of exception
	 * @param throwable
	 *            The actual root cause for the exception
	 */
	public InvalidCredentialsException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
