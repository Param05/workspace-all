package com.bankapp.service;

import java.util.List;

import com.bankapp.model.Customer;

public interface ICustomerService {

	public List<Customer> getAllCustomer();

	public Customer getCustomerById(int customerId);

	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer removeCustomer(int CustomerId);

}
