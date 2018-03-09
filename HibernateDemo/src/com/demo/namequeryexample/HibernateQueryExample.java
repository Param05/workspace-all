package com.demo.namequeryexample;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.util.HibernateUtil;

public class HibernateQueryExample {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionAnnotationFactory()
				.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session.getNamedQuery("@HQL_GET_ALL_ADDRESS");
		List<Address> addressList = query.list();
		for (Address addr : addressList) {
			System.out.println("List of address" + addr.getState().toString());
		}
	}
}
