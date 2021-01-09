package com.spring.common.exception.customhandler;

public class ResourceNotFoundExceptionHandler extends RuntimeException{

	private static final long serialVersionUID = 3961620340165662152L;

	public ResourceNotFoundExceptionHandler(String message){
		super(message);
	}
}
