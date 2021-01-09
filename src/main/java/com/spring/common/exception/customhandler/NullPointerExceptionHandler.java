package com.spring.common.exception.customhandler;

public class NullPointerExceptionHandler extends RuntimeException{

	private static final long serialVersionUID = -858088901557304952L;

	public NullPointerExceptionHandler(String message){
		super(message);
	}
}
