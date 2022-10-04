package com.pocexample.springboot.service;

import java.util.List;

import com.pocexample.springboot.model.User;

public interface UserService {
	User createUser(User user);

	User updateUser(User user);

	List<User> getAllUser();

	User getUserById(long userId);

	void deleteUser(long id);
}
