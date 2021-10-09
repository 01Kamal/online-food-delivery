package com.demo.food.exception;

public class CustomerNotFoundException extends Exception{
	
	public CustomerNotFoundException() {
		super();	
	}
	
	public CustomerNotFoundException(String message) {
		super(message);
	}
	
	public CustomerNotFoundException(Throwable cause) {
		super(cause);
	}

}
