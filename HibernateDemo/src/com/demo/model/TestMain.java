package com.demo.model;

import org.hibernate.Session;

import com.demo.util.HibernateUtil;

public class TestMain {
	public static void main(String[] args) throws InterruptedException {
		/*
		 * employee.setName("param"); employee.setRole("developer");
		 * employee.setInsertTime(new Date())
		 */;

		Session session = HibernateUtil.getSessionAnnotationFactory()
				.getCurrentSession();
		session.beginTransaction();
		/* session.save(employee); */
		Employee emp = (Employee) session.load(Employee.class, new Integer(1));
		System.out.println("Name is" + emp.getName());

		Thread.sleep(10000);

		Employee emp1 = (Employee) session.load(Employee.class, new Integer(1));
		System.out.println("Name is" + emp1.getName());

		Session newSession = HibernateUtil.getSessionAnnotationFactory()
				.openSession();
		Employee emp2 = (Employee) newSession.load(Employee.class, new Integer(1));
		System.out.println("Name is" + emp2.getName());
		
		
		
		Employee emp3 = (Employee) session.load(Employee.class, new Integer(2));
		System.out.println("Name is" + emp3.getName());

		
		session.evict(emp);
		System.out.println("Session Contains Employee with id=1?"+session.contains(emp));
		
		
		Employee emp11 = (Employee) session.load(Employee.class, new Integer(1));
		System.out.println("Name is" + emp11.getName());
		
		
		session.getTransaction().commit();
		HibernateUtil.getSessionAnnotationFactory().close();
	}
}
