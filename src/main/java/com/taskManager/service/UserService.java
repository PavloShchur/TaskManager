package com.taskManager.service;

import com.taskManager.entity.Task;
import com.taskManager.entity.User;

import java.util.List;

public interface UserService {
	void save(User user) throws Exception;

	List<User> findAll();

	User findOne(int id);

	void delete(int id);

	void update(User user);

	void addTaskToUser(User user, Task task);

    User findByUuid(String uuid);

//	void addGenreToBook(Book book, Genre genre);

//	User findUserByTask(int id);

}
