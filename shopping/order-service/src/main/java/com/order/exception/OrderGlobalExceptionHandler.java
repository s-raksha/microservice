package com.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class OrderGlobalExceptionHandler {
	
	@ExceptionHandler(OutOfStockException.class)
	public ResponseEntity<String> outOfStockException(OutOfStockException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	}

}
