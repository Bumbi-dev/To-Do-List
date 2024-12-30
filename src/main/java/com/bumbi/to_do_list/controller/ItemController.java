package com.bumbi.to_do_list.controller;

import com.bumbi.to_do_list.model.Item;
import com.bumbi.to_do_list.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemService service;

    @GetMapping("/items")
    public List<Item> getItems() {
        return service.getAllItems();
    }

    @GetMapping("/closestItems")
    public Item getClosestItemToDueDate() {
        return service.getClosestItemToDueDate();
    }

    @PostMapping("/items")
    public void addItem(@RequestBody Item item) {
        service.addItem(item);
    }
}
