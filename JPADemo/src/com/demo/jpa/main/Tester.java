package com.demo.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.demo.model.Customer;

public class Tester {
	public static void main(String[] args) {
		EntityManagerFactory fc = Persistence.createEntityManagerFactory("demo_jpa");
		EntityManager em = fc.createEntityManager();

		em.getTransaction().begin();

		Customer c = new Customer();
		c.setCustomerName("a");
		c.setCustomerAddess("aaa");

		em.persist(c);
		System.out.println("inserted...");
		em.getTransaction().commit();
		em.close();
		fc.close();

	}
}
