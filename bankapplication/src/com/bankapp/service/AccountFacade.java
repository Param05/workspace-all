package com.bankapp.service;


public interface AccountFacade {
	public void transfer(String from, String to, double amount)
			throws CustomException;
}
