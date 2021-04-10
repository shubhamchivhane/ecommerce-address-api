package com.ecom.api.exception;

public class UserNameAlreadyExistException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public UserNameAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserNameAlreadyExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
