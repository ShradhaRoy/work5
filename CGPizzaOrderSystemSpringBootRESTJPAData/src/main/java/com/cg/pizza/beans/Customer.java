package com.cg.pizza.beans;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	private String firstName;
	private String lastName;
	
	@Embedded
	Address address;
	
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@MapKey
	private Map<Integer, Pizza>pizza=new HashMap<Integer, Pizza>();

	public Customer() {
		super();
	}
	

	public Customer(String firstName, String lastName, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}


	public Customer(String firstName, String lastName, Address address, Map<Integer, Pizza> pizza) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.pizza = pizza;
	}

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public Map<Integer, Pizza> getPizza() {
		return pizza;
	}
	public void setPizza(Map<Integer, Pizza> pizza) {
		this.pizza = pizza;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", pizza=" + pizza + "]";
	}
}
