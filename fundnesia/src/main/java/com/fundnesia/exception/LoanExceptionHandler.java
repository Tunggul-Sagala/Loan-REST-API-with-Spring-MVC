package com.fundnesia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fundnesia.entity.LoanErrorResponse;

@ControllerAdvice
public class LoanExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<LoanErrorResponse> handleException(LoanNotFoundException exc) {
		LoanErrorResponse error =new LoanErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<LoanErrorResponse> handleException(Exception exc) {
		LoanErrorResponse error =new LoanErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
