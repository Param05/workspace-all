package com.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.Customer;
import com.bankapp.model.IAccountDao;

@Service
public class AccountServiceImp implements IAccountServ {

	@Autowired
	private IAccountDao accountDao;

	@Override
	public void transfer(String from, String to, double amount) {
		// account.getFromName();

		Customer fromAccount = accountDao.find(from);
		Customer toAccount = accountDao.find(to);
		fromAccount.setAmount(fromAccount.getAmount() - amount);
		toAccount.setAmount(toAccount.getAmount() + amount);
		accountDao.update(fromAccount);
		accountDao.update(toAccount);

	}

}
