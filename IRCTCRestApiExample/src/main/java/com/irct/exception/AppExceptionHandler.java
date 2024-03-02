package com.irct.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	@ExceptionHandler(IRCTCException.class)
	public ResponseEntity<ExceptionBean>handleIRCTCNotExist(IRCTCException exception)
	{
		String message = exception.getMessage();
		ExceptionBean E = new ExceptionBean();
		E.setCode("ERRXX1000");
		E.setMsg(message);
		return new ResponseEntity<>(E, HttpStatus.BAD_REQUEST);
		
	}
	
}
