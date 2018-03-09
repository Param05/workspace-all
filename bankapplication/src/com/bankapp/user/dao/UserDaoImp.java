package com.bankapp.user.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.user.model.User;
import com.bankapp.userInterface.UserDao;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public User findByUsername(String username) {

		User user = (User) getSession().getNamedQuery("findUserByUsername")
				.setString("username", username).list().get(0);

		user.getUserRole();
		return user;

	}
}
