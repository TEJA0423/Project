package com.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<ExceptionBean>handleStudentNotExist(StudentException exception)
	{
		String message = exception.getMessage();
		ExceptionBean eb = new ExceptionBean();
		eb.setCode("ERRXX1000");
		eb.setMsg(message);
		return new ResponseEntity<>(eb, HttpStatus.BAD_REQUEST);
		
	}
	
}
