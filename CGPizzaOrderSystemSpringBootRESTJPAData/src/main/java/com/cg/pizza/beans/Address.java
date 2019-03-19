package com.cg.pizza.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String city;
	private String locality;
	private int zipCode;

	public Address() {
		super();
	}

	public Address(String city, String locality, int zipCode) {
		super();
		this.city = city;
		this.locality = locality;
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}

	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", locality=" + locality + ", zipCode=" + zipCode + "]";
	}
}
