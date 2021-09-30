package com.demo.food.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.food.entity.RestaurantErrorResponse;

@ControllerAdvice
public class RestaurantExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<RestaurantErrorResponse> handleException(RestaurantNotFoundException exception) {
		RestaurantErrorResponse error = new RestaurantErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}

}
