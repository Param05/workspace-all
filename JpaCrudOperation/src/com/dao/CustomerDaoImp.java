package com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.util.EntityManagerUtil;

public class CustomerDaoImp implements CustomerDao {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Customer> getAllCustomer() {
		entityManager = EntityManagerUtil.getEntityManager();
		List<Customer> clist = entityManager.createQuery(
				"select c from Customer c", Customer.class).getResultList();

		return clist;
	}

	@Override
	public void addCustomer(Customer customer) {
		EntityManager entityManager = null;

		try {

			entityManager = EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(customer);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void removeCustomer(Customer c) {
		entityManager.remove(c);
	}

	@Override
	public Customer getCustomerById(int id) {
		return entityManager.find(Customer.class, id);

	}

	@Override
	public void updateCustomer(Customer c) {
		entityManager.merge(c);
	}

}
