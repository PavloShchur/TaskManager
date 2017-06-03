package com.taskManager.service;

import com.taskManager.entity.User;

import java.util.List;

public interface UserService {
	void save(User user) throws Exception;

	List<User> findAll();

	User findOne(int id);

	void delete(int id);

	void update(User user);

}
