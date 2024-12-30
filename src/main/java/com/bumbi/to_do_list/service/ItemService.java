package com.bumbi.to_do_list.service;

import com.bumbi.to_do_list.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    List <Item> repo = new ArrayList<Item>() {{
        add(new Item(1, "Learn Hand-Stand"));
        add(new Item(2, "Learn 3 Guitar Songs"));
    }};

    public List <Item> getAllItems() {
        return repo;
    }

    public Item getClosestItemToDueDate() {
        return repo.get(1);
    }

    public void addItem(Item item) {
        repo.add(item);
    }

    public void deleteItemById(int id) {
        //TODO
    }
}
