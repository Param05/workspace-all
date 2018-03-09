package com.demo.jpa.main;

import com.dao.Customer;
import com.dao.CustomerDao;
import com.dao.CustomerDaoImp;

public class Tester {
	public static void main(String[] args) {
		CustomerDao empDAO = new CustomerDaoImp();
		Customer customer = new Customer();
		customer.setCustomerName("amas");
		customer.setCustomerPassword("aa");
		customer.setCustomerAddess("111");
		empDAO.addCustomer(customer);
		System.out.println(empDAO.getAllCustomer());

	}
}
