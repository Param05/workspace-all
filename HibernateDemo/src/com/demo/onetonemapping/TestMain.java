package com.demo.onetonemapping;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.util.HibernateUtil;

public class TestMain {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionAnnotationFactory()
				.openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Address address1 = new Address("OMR Road", "Chennai", "TN",
					"600097");
			Address address2 = new Address("Ring Road", "Banglore",
					"Karnataka", "560000");

			Student student1 = new Student("Eswar", address1);
			Student student2 = new Student("Joe", address2);
			session.persist(student1);
			address1.setCity("Ludhiana");
			session.save(student2);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}