package com.demo.manytoone;

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

			Student student1 = new Student("Aman", address1);
			Student student2 = new Student("Aman", address2);
			session.save(student1);
			session.save(student2);
			/*
			 * session.save(address1); session.save(address2);
			 */

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}