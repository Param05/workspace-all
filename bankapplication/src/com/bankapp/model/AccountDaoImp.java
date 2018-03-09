package com.bankapp.model;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImp implements IAccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void update(Customer account) {
		/*
		 * Session session = sessionFactory.getCurrentSession(); Transaction tx
		 * = session.beginTransaction();
		 */
		sessionFactory.getCurrentSession().save(account);

	}

	@Override
	public Customer find(String accountNumber) {

		String hql = "FROM Customer C WHERE C.accountNumber = :account";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("account", accountNumber);
		Customer customer = (Customer) query.uniqueResult();
		System.out.println(customer);
		return customer;
	}

}
