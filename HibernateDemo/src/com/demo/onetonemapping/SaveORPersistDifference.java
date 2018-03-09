package com.demo.onetonemapping;

import org.hibernate.Session;

import com.demo.util.HibernateUtil;

public class SaveORPersistDifference {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionAnnotationFactory()
				.openSession();

		Address address1 = new Address("OMR Road", "Chennai", "TN", "600097");

		Student student = new Student("Eswar", address1);
		long id = (Long) session.save(student);
		System.out.println(" jhgjkghk" + id);
		session.flush();
	}
}
