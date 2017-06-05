package com.taskManager.dao;

import com.taskManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByNameAndEmail(String name, String email);

//	@Query("select u from User u left join fetch u.tasks where u.id=:id")
//	User findUserByTask(int id);

	User findByName(String name);

}
