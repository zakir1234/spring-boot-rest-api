package com.spring.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Zakir
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	
	private String className;
	private String methodName;
	private int lineNo;
	private String message;
	private String ipAddress;
	private String uri;
	private String error;
	private String exceptionClass;
	private String exceptionDetails;

}
