package com.bumbi.to_do_list.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.awt.*;
import java.util.Date;

@Entity
public class Item {

    @Id
    public int id;
    public String desc;
//    public Color priority;
//    public Date creationDate;
//    public Date dueDate;
//
//    public Item(int id, String desc, Color priority, Date creationDate, Date dueDate) {
//        this.id = id;
//        this.desc = desc;
//        this.priority = priority;
//        this.creationDate = creationDate;
//        this.dueDate = dueDate;
//    }

    public Item(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }
}
