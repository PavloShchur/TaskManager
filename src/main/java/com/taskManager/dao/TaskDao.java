package com.taskManager.dao;

import com.taskManager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskDao extends JpaRepository<Task, Integer> {
    @Query("select t from Task t left join fetch t.users where t.id=:id")
    Task findTaskWithUser(@Param("id") int id);
}
