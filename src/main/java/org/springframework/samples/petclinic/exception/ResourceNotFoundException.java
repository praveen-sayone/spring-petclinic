package org.springframework.samples.petclinic.exception;



public class ResourceNotFoundException extends RuntimeException {
	/**
	 * Constructs a ResourceNotFoundException with the specified detail message.
	 *
	 * @param message the detail message describing the missing resource
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
