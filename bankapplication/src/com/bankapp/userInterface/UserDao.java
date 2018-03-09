package com.bankapp.userInterface;

import com.bankapp.user.model.User;

public interface UserDao {

	User findByUsername(String username);

}
