package com.cg.pizza.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pizza {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	private int orderQty;
	private String pizzaType;
	private double totalAmount;

	@ManyToOne
	private  Customer customer;

	public Pizza() {
		super();
	}
	

	public Pizza(int orderQty, String pizzaType) {
		super();
		this.orderQty = orderQty;
		this.pizzaType = pizzaType;
	}


	public Pizza(int orderQty, String pizzaType, double totalAmount) {
		super();
		this.orderQty = orderQty;
		this.pizzaType = pizzaType;
		this.totalAmount = totalAmount;
	}


	public Pizza(int orderQty, String pizzaType, Customer customer,double totalAmount) {
		super();
		this.orderQty = orderQty;
		this.pizzaType = pizzaType;
		this.customer = customer;
		this.totalAmount=totalAmount;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public String getPizzaType() {
		return pizzaType;
	}
	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Pizza [orderId=" + orderId + ", orderQty=" + orderQty + ", pizzaType=" + pizzaType + ", totalAmount="
				+ totalAmount + ", customer=" + customer + "]";
	}
}
