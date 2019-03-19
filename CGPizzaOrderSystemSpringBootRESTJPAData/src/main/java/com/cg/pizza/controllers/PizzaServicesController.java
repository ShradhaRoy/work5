package com.cg.pizza.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.pizza.beans.Customer;
import com.cg.pizza.beans.Pizza;
import com.cg.pizza.exceptions.CustomerDetailsNotfoundException;
import com.cg.pizza.exceptions.OrderDetailsNotfoundException;
import com.cg.pizza.services.PizzaService;

@Controller
public class PizzaServicesController {

	@Autowired
	PizzaService pizzaServices;

	@RequestMapping(value= {"/acceptCustomerDetails"},method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String>acceptEmployeeDetails(@ModelAttribute Customer customer){
		customer=pizzaServices.acceptCustomerDetails(customer);
		return new ResponseEntity<>("Customer Details Successfully Added Customer Id:- "+customer.getCustomerId(),HttpStatus.OK);
	}

	@RequestMapping(value= {"/getCustomerDetails"},method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json")
	public ResponseEntity<Customer>getCustomerDetails(@RequestParam int custId) throws CustomerDetailsNotfoundException{
		Customer customer=pizzaServices.getCustomerDetails(custId);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}

	@RequestMapping(value= {"/acceptOrderDetails"},method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String>acceptOrderDetails(@RequestParam int custId,@ModelAttribute Pizza pizza) throws CustomerDetailsNotfoundException{
		pizza=pizzaServices.acceptOrderDetails(custId, pizza);
		return new ResponseEntity<>("Order placed successfully and order id is : "+pizza.getOrderId(),HttpStatus.OK);
	}

	@RequestMapping(value= {"/getPizzaDetails"},method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json")
	public ResponseEntity<Pizza>getPizzaDetails(@RequestParam int orderId) throws OrderDetailsNotfoundException{
		Pizza pizza=pizzaServices.getPizzaDetails(orderId);
		return new ResponseEntity<Pizza>(pizza,HttpStatus.OK);
	}

	@RequestMapping(value= {"/getAllOrderDetails"},method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json")
	public ResponseEntity<List<Pizza>>getAllOrderDetailsRequestParamVariable(){
		return new ResponseEntity<List<Pizza>>(pizzaServices.getAllOrderDetails(),HttpStatus.OK);
	}

	@RequestMapping(value= {"/removeOrderDetails"},method=RequestMethod.DELETE,
			produces=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String>removeOrderDetails(@RequestParam int orderId) throws OrderDetailsNotfoundException{
		pizzaServices.removeOrderDetails(orderId);
		return new ResponseEntity<>("Pizza Details Successfully Removed! ",HttpStatus.OK);
	}

	@RequestMapping(value= {"/calculateOrderPrice"},method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json")
	public ResponseEntity<String> calculateOrderPrice(@RequestParam int orderQty,@RequestParam String pizzaType){
		return new ResponseEntity<> ("Total Amount Calculated is "+pizzaServices.calculateOrderPrice(orderQty, pizzaType),HttpStatus.OK);
	}	
}
