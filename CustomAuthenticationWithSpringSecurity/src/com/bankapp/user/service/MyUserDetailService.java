package com.bankapp.user.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.stereotype.Service;

import com.bankapp.user.dao.UserDao;
import com.bankapp.user.model.User;

@Service("myUserDetailsService")
@Transactional
public class MyUserDetailService extends ResourceServerConfigurerAdapter {

	@Autowired
	private UserDao userDao;

	public User loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return userDao.findByUsername(username);

	}

}
