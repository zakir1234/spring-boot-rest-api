package com.spring.common.exception.customhandler;

/**
 * 
 * @author Zakir
 *
 */
public class BadRequestExceptionHandler extends RuntimeException{

	private static final long serialVersionUID = 2856530898327230542L;
	
	public BadRequestExceptionHandler(String message){
		super(message);
	}

}
