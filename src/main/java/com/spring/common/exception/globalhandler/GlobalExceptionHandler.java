package com.spring.common.exception.globalhandler;

import java.nio.file.AccessDeniedException;
import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.spring.common.enums.ErrorMessageContainer;
import com.spring.common.response.ErrorResponse;

/**
 * 
 * @author Zakir
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value= {MissingServletRequestParameterException.class, IllegalArgumentException.class, IllegalStateException.class})
	public ResponseEntity<?> handleBadRequestException(HttpServletRequest req, Exception e) {	
		    return new ResponseEntity<>(prepareException(req,e,ErrorMessageContainer.MESSAGE_TYPE_BAD_REQUEST.getMessageTitle()), HttpStatus.BAD_REQUEST);		
	}

	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler({ AuthenticationException.class, AccessDeniedException.class })
	public ResponseEntity<?> handleAuthenticationException(HttpServletRequest req, Exception e) {
	
		 return new ResponseEntity<>(prepareException(req,e,ErrorMessageContainer.MESSAGE_TYPE_UNAUTHORIZED.getMessageTitle()), HttpStatus.UNAUTHORIZED);		
		
	}

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(value = {DataIntegrityViolationException.class})
	public ResponseEntity<?> handleIllegealArgumentException(HttpServletRequest req, Exception e) {
		 return new ResponseEntity<>(prepareException(req,e,ErrorMessageContainer.MESSAGE_TYPE_DUPlICATE_ENTRY.getMessageTitle()), HttpStatus.CONFLICT);		
	}


	@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({NullPointerException.class })
	public ResponseEntity<?> handleNullPointerException(HttpServletRequest req, Exception e) {
	
		 return new ResponseEntity<>(prepareException(req,e,ErrorMessageContainer.MESSAGE_TYPE_NULL_POINTER_EXCEPTION.getMessageTitle()), HttpStatus.INTERNAL_SERVER_ERROR);		
	}	
	
	
	@ExceptionHandler({Exception.class })
	public ResponseEntity<?> handleIllegalDeniedException(HttpServletRequest req, Exception e) {

		 return new ResponseEntity<>(prepareException(req,e,ErrorMessageContainer.MESSAGE_TYPE_SOMETHIN_WRONG.getMessageTitle()), HttpStatus.INTERNAL_SERVER_ERROR);		

	}

	private ErrorResponse prepareException(HttpServletRequest req, Exception e, String localMessage) {
	return	ErrorResponse.builder().className(e.getClass().getName())
				.ipAddress(req.getRemoteAddr()).uri(req.getServletPath())
				.lineNo(e.getStackTrace()[0].getLineNumber()).methodName(e.getStackTrace()[0].getMethodName())
				.className(e.getStackTrace()[0].getClassName())			
				.message(localMessage)
				.error(e.getMessage())
				.exceptionClass(e.getClass().getName())
				.exceptionDetails(ExceptionUtils.getStackTrace(e))  
				.build();	
	}
}