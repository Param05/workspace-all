package com.demo.onetonemapping;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.util.HibernateUtil;

public class HqlExample {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionAnnotationFactory()
				.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Student");
		List<Student> studentList = query.list();
		for (Student student : studentList) {
			System.out.println("================" + student.getStudentName()
					+ "" + student.getStudentAddress().getCity()
					+ "============");
		}

		query = session.createQuery("from Student where studentId= :id");
		query.setLong("id", 2);
		Student student = (Student) query.uniqueResult();
		System.out.println("Employee Name=" + student.getStudentName()
				+ ", City=" + student.getStudentAddress().getCity());

		query = session
				.createQuery("update Student set studentName= :student_name where studentId= :id");
		query.setParameter("student_name", "Pankaj Kumar");
		query.setLong("id", 1);
		int result = query.executeUpdate();
		System.out.println("Employee Update Status=" + result);

		query = session.createQuery("from Student where studentId= :id");
		query.setLong("id", 1);
		Student std = (Student) query.uniqueResult();
		System.out.println("Employee Name=" + std.getStudentName() + ", City="
				+ std.getStudentAddress().getCity());

		tx.commit();
		// closing hibernate resources
		session.close();
	}
}
