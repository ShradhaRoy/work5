package com.cg.pizza.services;

import java.util.List;
import com.cg.pizza.beans.Customer;
import com.cg.pizza.beans.Pizza;
import com.cg.pizza.exceptions.CustomerDetailsNotfoundException;
import com.cg.pizza.exceptions.OrderDetailsNotfoundException;

public interface PizzaService {
	Customer acceptCustomerDetails(Customer customer);
	Customer getCustomerDetails(int custId) throws CustomerDetailsNotfoundException; 
	Pizza acceptOrderDetails(int custId,Pizza pizza) throws CustomerDetailsNotfoundException; 
	Pizza getPizzaDetails(int orderId) throws OrderDetailsNotfoundException; 
	List<Pizza> getAllOrderDetails();
	boolean removeOrderDetails(int orderId) throws OrderDetailsNotfoundException;
	double calculateOrderPrice(int orderQty,String pizzaType);
}
