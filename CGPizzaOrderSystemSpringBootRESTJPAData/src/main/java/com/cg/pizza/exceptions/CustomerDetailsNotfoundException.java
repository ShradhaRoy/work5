package com.cg.pizza.exceptions;

public class CustomerDetailsNotfoundException extends Exception{

	public CustomerDetailsNotfoundException() {
		super();
	}

	public CustomerDetailsNotfoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CustomerDetailsNotfoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerDetailsNotfoundException(String message) {
		super(message);
	}

	public CustomerDetailsNotfoundException(Throwable cause) {
		super(cause);
	}
}
