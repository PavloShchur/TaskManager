package com.taskManager.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 02.06.2017.
 */

@Entity
public class Task extends AbstractEntity {

    private LocalDateTime localDateTime;

    private String titleOfTask;

    private String descriptionOfTask;

    @OneToMany(mappedBy = "task",fetch = FetchType.LAZY)
    private List<User> users;
    /*
    * private List<User> users = new ArrayList<>();
     */


    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Task() {

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
