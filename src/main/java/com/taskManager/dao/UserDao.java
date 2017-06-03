package com.taskManager.dao;

import com.taskManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByNameAndEmail(String name, String email);

	User findByName(String name);

}
