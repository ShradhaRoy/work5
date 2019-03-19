package com.cg.pizza.exceptions;

public class OrderDetailsNotfoundException extends Exception {

	public OrderDetailsNotfoundException() {
		super();
	}

	public OrderDetailsNotfoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OrderDetailsNotfoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderDetailsNotfoundException(String message) {
		super(message);
	}

	public OrderDetailsNotfoundException(Throwable cause) {
		super(cause);
	}
}
