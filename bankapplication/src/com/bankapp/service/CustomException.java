package com.bankapp.service;

public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3554329872827619577L;

	public CustomException(String message) {
		super(message);
		System.out.println(message);
	}
}
