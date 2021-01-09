package com.spring.common.exception.customhandler;

public class DuplicateEntryExceptionHandler extends RuntimeException{

	private static final long serialVersionUID = -1199999450268797407L;

	public DuplicateEntryExceptionHandler(String message){
		super(message);
	}
}
