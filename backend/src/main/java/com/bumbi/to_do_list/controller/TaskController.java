package com.bumbi.to_do_list.controller;

import com.bumbi.to_do_list.model.Task;
import com.bumbi.to_do_list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TaskController {
    @Autowired
    TaskService service;

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return service.getAllTasks();
    }

    @PostMapping("/tasks")
    public void addTask(@RequestBody Task task) {
        service.addTask(task);
    }

    @PutMapping("/tasks")
    public void updateTask(@RequestBody Task task) {
        service.updateTask(task);
    }

    @DeleteMapping("/tasks")
    public void nukeTasks() {
        service.nukeTasks();
    }

    @GetMapping("/closestTask")
    public Task getClosestTaskToDueDate() {
        return service.getClosestTaskToDueDate();
    }

    @DeleteMapping("/tasks/{id}")
    public void nukeTasks(@PathVariable int id) {
        service.deleteTaskById(id);
    }
}
