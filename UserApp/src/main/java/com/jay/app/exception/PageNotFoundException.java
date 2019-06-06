package com.jay.app.exception;

public class PageNotFoundException extends Exception {
	
    private String message ="Page Not Found";
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String toString() {
		return  "";
	}

}
