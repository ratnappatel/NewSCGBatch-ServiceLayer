package com.infy.utility;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<ErrorInfo> exceptionHandler(NumberFormatException exception) {
		
		ErrorInfo error=new ErrorInfo();
		error.setErrorMessage("Cannot accept character in place of ID value");
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value()); // value method to convert HttpStatus enum obj to int type
		error.setErrorTime(LocalDateTime.now());
        return new ResponseEntity<ErrorInfo>(error, HttpStatus.INTERNAL_SERVER_ERROR);			
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> jsonFormatException(HttpMessageNotReadableException e)
	{
		return new ResponseEntity<>("RequestBody Customer Object syntax is incorrect"+"\ntime: "+ new Date(), HttpStatus.BAD_REQUEST);
	}
}
