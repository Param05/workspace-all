package com.bankapp.model;

import java.util.List;

public interface ICustomerDao {
	public List<Customer> getAllCustomer();

	public Customer getCustomerById(int customerId);

	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer removeCustomer(int CustomerId);

}
