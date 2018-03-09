package com.bankapp.model;

public interface IAccountDao {
	public void update(Customer account);

	public Customer find(String acountNumber);
}
