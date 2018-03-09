package com.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountFacadeImp implements AccountFacade {

	@Autowired
	private IAccountServ accountServ;

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	@Override
	public void transfer(String from, String to, double amount)
			throws CustomException {

		if (amount <= 1) {
			throw new CustomException("Hiii");
		} else {
			accountServ.transfer(from, to, amount);
		}
	}
}
