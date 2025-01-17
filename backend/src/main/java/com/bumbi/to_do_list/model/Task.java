package com.bumbi.to_do_list.model;

import jakarta.persistence.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
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
            creationDate = formatDate(new Date());

            dueDate = new Date(creationDate.getTime() + 24 * 60 * 60 * 1000);
            dueDate = formatDate(dueDate);
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

    private Date formatDate(Date date) {
        ZonedDateTime zoneDate = ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of("Europe/Bucharest"));//TODO fix timezone

        zoneDate = zoneDate.withMinute(0).withSecond(0).withNano(0);

        return Date.from(zoneDate.toInstant());
    }

    public Task() {}
}
