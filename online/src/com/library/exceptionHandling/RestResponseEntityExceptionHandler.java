package com.library.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

	@ExceptionHandler(GloabalExceptions.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception ex) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.OK);

	}
	/*
	 * @ExceptionHandler(Exception.class) public ResponseEntity<ErrorInfo>
	 * exceptionHandle1r(Exception ex) { System.out.println(ex.getMessage());
	 * ErrorInfo error = new ErrorInfo();
	 * error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
	 * error.setMessage(ex.getMessage()); return new
	 * ResponseEntity<ErrorInfo>(error, HttpStatus.OK);
	 * 
	 * }
	 */

	

}