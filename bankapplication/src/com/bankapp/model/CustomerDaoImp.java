package com.bankapp.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImp implements ICustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Customer> getAllCustomer() {
		
	/*	Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();*/

		@SuppressWarnings("unchecked")
		List<Customer> personsList = getSession().createQuery("from Customer")
				.list();
		return personsList;

	}

	@Override
	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer addCustomer(Customer customer) {
	/*	Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		*/
		getSession().save(customer);
		/*tx.commit();*/
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer removeCustomer(int CustomerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
