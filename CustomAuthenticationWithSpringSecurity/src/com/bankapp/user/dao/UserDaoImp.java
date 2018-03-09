package com.bankapp.user.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.bankapp.user.model.User;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@CacheEvict(value = "userDetails")
	@Cacheable(value = "userDetails", key = "#username")
	public User findByUsername(String username) {

		User user = (User) getSession().getNamedQuery("findUserByUsername")
				.setString("username", username).list().get(0);
		System.out.println("==============user name is =============="
				+ user.getUsername());
		user.getUserRole();
		return user;

	}
}
