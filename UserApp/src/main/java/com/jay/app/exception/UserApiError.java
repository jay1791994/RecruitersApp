package com.jay.app.exception;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserApiError{
	
	private HttpStatus status;
	  
	   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	   private LocalDateTime timestamp;
	   private String message;
	   private String debugMessage;

	   public UserApiError() {
		this.timestamp = LocalDateTime.now();	
		
	   }

	   public UserApiError(HttpStatus status) {
		this();
		this.status = status;
	   }

	   public UserApiError(HttpStatus status, String message, Throwable th) {
		this();
		this.status = status;
		this.message = message;
		this.setDebugMessage(th.getMessage());
	   }
	
	
	   public HttpStatus getStatus() {
		return status;
	   }
	   public void setStatus(HttpStatus status) {
		this.status = status;
	   }
	   public LocalDateTime getTimestamp() {
		return timestamp;
	   }
	   public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	   }
	   public String getMessage() {
		return message;
	   }
	   public void setMessage(String message) {
		this.message = message;
	   }
	   public String getDebugMessage() {
		return debugMessage;
	   }
	   public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	   }

}
