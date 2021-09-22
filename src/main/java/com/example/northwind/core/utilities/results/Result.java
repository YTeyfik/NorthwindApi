package com.example.northwind.corre.utilities.results;


public class Result {
	private boolean success;
	private String message;
	
	public Result(boolean success) {
		this.success = success;
	}
	public Result(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public String getMessage() {
		return message;
	}
	
	
	
	
}
