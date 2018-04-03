package com.moviestore.exception;

import java.util.Date;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;


public abstract class AbstractControllerExceptionHandler {

	@ExceptionHandler(value = {ConstraintViolationException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ApiErrorResponse> constraintViolationException(ConstraintViolationException ex, WebRequest request) {
		ApiErrorResponse errorDetails = new ApiErrorResponse(new Date(), ex.getMessage(),
			        request.getDescription(false));
			    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = {NoHandlerFoundException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ApiErrorResponse> noHandlerFoundException(Exception ex,WebRequest request) {
		ApiErrorResponse errorDetails = new ApiErrorResponse(new Date(), ex.getMessage(),
		        request.getDescription(false));
		    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {NullPointerException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ApiErrorResponse> unknownException(Exception ex, WebRequest request) {
		ApiErrorResponse errorDetails = new ApiErrorResponse(new Date(), ex.getMessage(),
		        request.getDescription(false));
		    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	@ExceptionHandler(value = {Exception.class })
//	@ResponseStatus(HttpStatus.UNAUTHORIZED)
//	public ResponseEntity<ApiErrorResponse> unauthorizedException(Exception ex, WebRequest request) {
//		ApiErrorResponse errorDetails = new ApiErrorResponse(new Date(), ex.getMessage(),
//		        request.getDescription(false));
//		    return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
//	}
//	
//	@ExceptionHandler(value = {Exception.class })
//	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
//	public ResponseEntity<ApiErrorResponse> unsupportedException(Exception ex, WebRequest request) {
//		ApiErrorResponse errorDetails = new ApiErrorResponse(new Date(), ex.getMessage(),
//		        request.getDescription(false));
//		    return new ResponseEntity<>(errorDetails, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
//	}

}
