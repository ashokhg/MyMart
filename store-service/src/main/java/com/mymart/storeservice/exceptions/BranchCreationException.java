package com.mymart.storeservice.exceptions;

public class BranchCreationException extends RuntimeException {

	private static final long serialVersionUID = 4257715740920620212L;

	public BranchCreationException(String message) {
		super(message);
	}
	
	public BranchCreationException(String message, Throwable cause) {
		super(message, cause);
	}
}
