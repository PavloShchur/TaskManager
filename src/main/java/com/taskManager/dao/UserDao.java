package com.taskManager.dao;

import com.taskManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByNameAndEmail(String name, String email);

	User findByName(String name);

	@Query("select u from User u where u.uuid =:uuid")
	User findByUuid(@Param("uuid") String uuid);

}
