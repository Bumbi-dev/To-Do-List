package com.bumbi.to_do_list.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String desc;
    private Integer color;
    private Date creationDate;
    private Date dueDate;

    @PrePersist
    private void onCreate() {
        if (this.creationDate == null) {
            this.creationDate = new Date();
        }
        if (this.dueDate == null) {
            this.dueDate = new Date(this.creationDate.getTime() + 24 * 60 * 60 * 1000);
        }
    }

    public Task(String desc, int color) {
        this.desc = desc;
        this.color = color;
    }

    public long timeToDueDate() {
        return dueDate.getTime() - new Date().getTime();
    }

    public Long getId() {
        return id;
    }
    public String getDesc() {
        return desc;
    }
    public int getColor() {
        return color;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public Date getDueDate() {
        return dueDate;
    }

    public Task() {}
}
