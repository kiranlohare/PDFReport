package com.kiran.reportgenerator.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final Logger log=LoggerFactory.getLogger(StudentNotFoundException.class);
	private static final long serialVersionUID = 6602626189110928550L;
	
	public StudentNotFoundException(String msg) {
		super(msg);
		log.info ("Student not found with the given id");
	}
}
