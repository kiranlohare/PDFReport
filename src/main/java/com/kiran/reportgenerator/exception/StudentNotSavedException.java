package com.kiran.reportgenerator.exception;

public class StudentNotSavedException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4158676759150553775L;

	/**
	 * Used to throw exception when user id not found in persistence layer
	 */
	public StudentNotSavedException(String message) {
		super(message);
	}
}
