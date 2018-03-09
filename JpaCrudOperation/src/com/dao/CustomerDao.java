package com.dao;

import java.util.List;

public interface CustomerDao {

	public List<Customer> getAllCustomer();

	public void addCustomer(Customer c);

	public void removeCustomer(Customer c);

	public Customer getCustomerById(int id);

	public void updateCustomer(Customer c);
}