package com.cg.pizza.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.cg.pizza.exceptions.OrderDetailsNotfoundException;
import com.cg.pizza.responses.CustomResponse;

@ControllerAdvice
public class PizzaExceptionAspect {

	@ExceptionHandler(OrderDetailsNotfoundException.class)
	public ResponseEntity<CustomResponse> handleEmployeeDetailsNotFoundException(Exception e) {
		CustomResponse response=new CustomResponse(e.getMessage(),HttpStatus.EXPECTATION_FAILED.value());
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}
}
