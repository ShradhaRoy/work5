package com.cg.pizza.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.pizza.beans.Customer;
import com.cg.pizza.beans.Pizza;
import com.cg.pizza.daoservices.CustomerDAO;
import com.cg.pizza.daoservices.PizzaDAO;
import com.cg.pizza.exceptions.CustomerDetailsNotfoundException;
import com.cg.pizza.exceptions.OrderDetailsNotfoundException;

@Component("pizzaServices")
public class PizzaServiceImpl implements PizzaService {

	@Autowired
	PizzaDAO pizzaDao;
	@Autowired
	CustomerDAO customerDao;

	@Override
	public Customer acceptCustomerDetails(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public Customer getCustomerDetails(int custId) throws CustomerDetailsNotfoundException {
		return customerDao.findById(custId).orElseThrow(()->new CustomerDetailsNotfoundException("Customer Details Not Found For Order Id: "+custId));
	}

	@Override
	public Pizza acceptOrderDetails(int custId, Pizza pizza) throws CustomerDetailsNotfoundException {
		Customer customer=getCustomerDetails(custId);
		pizza.setCustomer(customer); //CustomerId in Pizza Table
		return pizzaDao.save(pizza);
	}

	@Override
	public Pizza getPizzaDetails(int orderId) throws OrderDetailsNotfoundException {
		return pizzaDao.findById(orderId).orElseThrow(()->new OrderDetailsNotfoundException("Order Details Not Found For Order Id:"+orderId));
	}

	@Override
	public List<Pizza> getAllOrderDetails() {
		return pizzaDao.findAll();
	}

	@Override
	public boolean removeOrderDetails(int orderId) throws OrderDetailsNotfoundException {
		pizzaDao.delete(getPizzaDetails(orderId));
		return true;
	}

	@Override
	public double calculateOrderPrice(int orderQty,String pizzaType) {
		if(pizzaType.equalsIgnoreCase("veg")) {
			double totalAmount=(200*orderQty)*0.18;
			return totalAmount;
		}
		else if(pizzaType.equalsIgnoreCase("nonVeg")) {
			double totalAmt=(250*orderQty)*0.18;
			return totalAmt;
		}
		else {
			System.out.println("Please Enter Valid Pizza Type<Veg/NonVeg>");
			return 0;
		}
	
	}
}
