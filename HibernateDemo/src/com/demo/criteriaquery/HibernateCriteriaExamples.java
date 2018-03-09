package com.demo.criteriaquery;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.demo.util.HibernateUtil;

public class HibernateCriteriaExamples {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionAnnotationFactory()
				.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Student.class);
		List<Student> empList = criteria.list();
		for (Student emp : empList) {
			System.out.println(emp.getStudentName());
		}

		criteria = session.createCriteria(Student.class).add(
				Restrictions.eq("studentId", new Integer(1)));
		Student emp = (Student) criteria.uniqueResult();
		System.out.println("Name=" + emp.getStudentName());

	}
}