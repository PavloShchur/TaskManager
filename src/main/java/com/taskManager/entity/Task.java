package com.taskManager.entity;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;



@Entity
public class Task extends AbstractEntity {

    private LocalDateTime localDateTime;

    private String titleOfTask;

    private String descriptionOfTask;

    public Task() {
    }

    public Task(LocalDateTime localDateTime, String titleOfTask, String descriptionOfTask) {
        this.localDateTime = localDateTime;
        this.titleOfTask = titleOfTask;
        this.descriptionOfTask = descriptionOfTask;
    }



    @OneToMany(mappedBy = "task",fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();
    /*
    * private List<User> users = new ArrayList<>();
     */

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }







    public String getTitleOfTask() {
        return titleOfTask;
    }

    public void setTitleOfTask(String titleOfTask) {
        this.titleOfTask = titleOfTask;
    }

    public String getDescriptionOfTask() {
        return descriptionOfTask;
    }

    public void setDescriptionOfTask(String descriptionOfTask) {
        this.descriptionOfTask = descriptionOfTask;
    }
}
