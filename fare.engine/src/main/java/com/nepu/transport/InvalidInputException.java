package com.nepu.transport;

/**
 * Exception thrown when the input to the Fare  Engine is null or empty.
 */
public class InvalidInputException extends RuntimeException {
	public InvalidInputException(String errorMessage) {
		super(errorMessage);
	}
}
