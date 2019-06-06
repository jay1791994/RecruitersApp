package com.jay.app.exception;

public class EntityNotFoundException extends Exception {

	
	private String message ="Entity Not Found";
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
