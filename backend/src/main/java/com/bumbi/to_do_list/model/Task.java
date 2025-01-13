package com.bumbi.to_do_list.model;

import jakarta.annotation.Priority;
import jakarta.persistence.*;

import java.awt.*;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "description")
    private String desc;
    private Color priority;
    private Date creationDate;
    private Date dueDate;

    public Task(String desc, Color priority) {
        this.desc = desc;
        this.priority = priority;
        creationDate = new Date();

        //1 day
        this.dueDate = new Date();
        dueDate.setTime(dueDate.getTime() + 24 * 60 * 60 * 1000);
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;

    }

    public long timeToDueDate() {
        return dueDate.getTime() - new Date().getTime();
    }
}
