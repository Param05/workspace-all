package com.bankapp.user.dao;

import com.bankapp.user.model.User;

public interface UserDao {

	User findByUsername(String username);

}
