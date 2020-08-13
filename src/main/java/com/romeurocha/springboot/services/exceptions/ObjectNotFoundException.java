package com.romeurocha.springboot.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String text) {
		super(text);
	}
	
	public ObjectNotFoundException(String text,Throwable cause) {
		super(text,cause);
	} 
	
}
