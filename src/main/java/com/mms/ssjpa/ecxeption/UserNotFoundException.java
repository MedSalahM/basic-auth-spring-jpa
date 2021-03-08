package com.mms.ssjpa.ecxeption;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String id) {
		// TODO Auto-generated constructor stub
	   super("User number "+id+" Does not exist");
	
	}
}
