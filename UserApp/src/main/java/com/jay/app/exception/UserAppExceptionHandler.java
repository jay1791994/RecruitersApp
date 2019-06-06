package com.jay.app.exception;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice("com.jay.app.controller")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UserAppExceptionHandler/* extends ResponseEntityExceptionHandler */ {

	@ExceptionHandler(value = { HttpMessageNotReadableException.class })
	ResponseEntity<UserApiError> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {

		System.out.println("exception handler called");
		UserApiError err = new UserApiError(HttpStatus.NOT_ACCEPTABLE, "Invalid JSON format", ex);
		return ResponseEntity.status(405).body(err);
	}

	@ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
	ResponseEntity<UserApiError> handle(HttpRequestMethodNotSupportedException ex) {

		System.out.println("exception handler called");
		UserApiError err = new UserApiError(HttpStatus.BAD_REQUEST, "Request Method Not Supported", ex);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(value = { EntityNotFoundException.class })
	ResponseEntity<UserApiError> handleexception() {

		System.out.println("exception handler called");
		UserApiError err = new UserApiError(HttpStatus.NOT_FOUND, "Wrong USER ID", new EntityNotFoundException());
		return ResponseEntity.status(400).body(err);

	}

	@ExceptionHandler(value = { PageNotFoundException.class })
	ResponseEntity<UserApiError> handlepagenotfoundexception() {
		System.out.println("exception handler called");
		UserApiError err = new UserApiError(HttpStatus.BAD_REQUEST, "Page number is not Valid",
				new PageNotFoundException());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
