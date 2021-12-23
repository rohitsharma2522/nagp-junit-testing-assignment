package com.nagarro.model;

public class TradeResponse {
	
	int statusCode;
	String remarks;
	
	public TradeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TradeResponse(int statusCode, String remarks) {
		super();
		this.statusCode = statusCode;
		this.remarks = remarks;
	}

	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}	
