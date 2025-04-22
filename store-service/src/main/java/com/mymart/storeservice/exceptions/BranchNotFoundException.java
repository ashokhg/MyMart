package com.mymart.storeservice.exceptions;

public class BranchNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	BranchNotFoundException(String message){
		super(message);
	}

	BranchNotFoundException(String message, Throwable cause){
		super(message, cause);
	}
}
