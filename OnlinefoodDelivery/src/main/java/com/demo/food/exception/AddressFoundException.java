package com.demo.food.exception;

public class AddressFoundException extends RuntimeException  {
	public AddressFoundException() {
		super();
		
	}

	public AddressFoundException(String message) {
		super(message);
		
	}

	public AddressFoundException(Throwable cause) {
		super(cause);
		
	}
}