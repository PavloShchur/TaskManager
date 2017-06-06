package com.taskManager.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by User on 02.06.2017.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task extends AbstractEntity {

    private LocalDateTime localDateTime;

    private String titleOfTask;

    private String descriptionOfTask;

    @Getter
    @Setter
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



    public Task(LocalDateTime localDateTime, String titleOfTask, String descriptionOfTask) {
        this.localDateTime = localDateTime;
        this.titleOfTask = titleOfTask;
        this.descriptionOfTask = descriptionOfTask;
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
