package com.demo.onetomany;

import java.util.HashSet;
import java.util.Set;

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
			
			Student student1 = new Student();
			student1.setStudentName("Eswar");
			
			Address address1 = new Address("OMR Road", "Chennai", "TN",
					"600097");
			address1.setStudent(student1);
			Address address2 = new Address("Ring Road", "Banglore",
					"Karnataka", "560000");
			address2.setStudent(student1);
			Set<Address> set = new HashSet<Address>();
			set.add(address1);
			set.add(address2);
			student1.setAddresses(set);
			session.save(student1);
			/*session.save(address1);
			session.save(address2);*/
			
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}