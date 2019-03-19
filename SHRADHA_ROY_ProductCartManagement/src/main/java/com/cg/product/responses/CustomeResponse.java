package com.cg.product.responses;

public class CustomeResponse {
	private String errorMessage;
	private int statusCode;
	public CustomeResponse() {}
	public CustomeResponse(String errorMessage,int statusCode) {
		super();
		this.errorMessage=errorMessage;
		this.statusCode=statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "CustomeResponse [errorMessage=" + errorMessage + ", statusCode=" + statusCode + "]";
	}

}
