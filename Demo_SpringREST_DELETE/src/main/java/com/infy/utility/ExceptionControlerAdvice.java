package com.infy.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.exception.InfyBankException;

@RestControllerAdvice
public class ExceptionControlerAdvice {
	
	@Autowired Environment env;
	
	@ExceptionHandler(InfyBankException.class)
	public ResponseEntity<String> infyBankExceptionHandler(InfyBankException e)
	{
		// Manually identifying ResponseStatus Code as 404 according to our logic 
		return new ResponseEntity<>(env.getProperty(e.getMessage()),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<String> exceptionHandler(NumberFormatException exception) {
        return new ResponseEntity<>("Cannot accept character in place of ID value", HttpStatus.INTERNAL_SERVER_ERROR);			
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> jsonFormatException(HttpMessageNotReadableException e)
	{
		return new ResponseEntity<>("RequestBody Customer Object syntax is incorrect", HttpStatus.BAD_REQUEST);
	}
}
