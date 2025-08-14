package org.springframework.samples.petclinic.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler {
	/**
	 * Handles ResourceNotFoundException by returning a 404 response with a JSON body containing the exception message.
	 *
	 * <p>Response body shape: {"message": "<exception message>"}</p>
	 *
	 * @param ex the ResourceNotFoundException whose message will be returned to the client
	 * @return a ResponseEntity with HTTP status 404 (NOT_FOUND) and a Map<String,String> body containing the error message
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleNotFound(ResourceNotFoundException ex) {
		Map<String, String> error = new HashMap<>();
		error.put("message", ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	/**
	 * Handles all uncaught exceptions and returns a standardized 500 response.
	 *
	 * Returns a ResponseEntity with HTTP 500 (INTERNAL_SERVER_ERROR) and a JSON body
	 * containing a single "message" entry with the value "internal server error".
	 *
	 * @param ex the exception that was caught and handled
	 * @return a ResponseEntity containing a map with the error message and status 500
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleGeneric(Exception ex) {
		Map<String, String> error = new HashMap<>();
		error.put("message", "internal server error");
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
