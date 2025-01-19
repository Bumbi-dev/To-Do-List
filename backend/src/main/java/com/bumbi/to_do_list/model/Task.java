package com.bumbi.to_do_list.model;

import jakarta.persistence.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String desc;
    private String color;
    private Date creationDate;
    private Date dueDate;

    @PrePersist
    private void onCreate() {
        creationDate = formatDate(new Date());

        dueDate = new Date(creationDate.getTime() + 24 * 60 * 60 * 1000);
        dueDate = formatDate(dueDate);
    }

    public Task(String desc, String color) {
        this.desc = desc;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }
    public String getDesc() {
        return desc;
    }
    public String getColor() {
        return color;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public Date getDueDate() {
        return dueDate;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    private Date formatDate(Date date) {
        ZonedDateTime zoneDate = ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of("Europe/Bucharest"));//TODO fix timezone

        zoneDate = zoneDate.withMinute(0).withSecond(0).withNano(0);

        return Date.from(zoneDate.toInstant());
    }

    public Task() {}
}
