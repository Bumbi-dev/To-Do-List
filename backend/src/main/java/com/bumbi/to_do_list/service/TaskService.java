package com.bumbi.to_do_list.service;

import com.bumbi.to_do_list.model.Task;
import com.bumbi.to_do_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repo;

    public List <Task> getAllTasks() {
        return repo.findAll();
    }

    public Task getClosestTaskToDueDate() {
        Task closestTask = repo.findAll().getFirst();

        for(Task task : repo.findAll())
            if(task.timeToDueDate() < closestTask.timeToDueDate())
                closestTask = task;

        return closestTask;
    }

    public void addTask(Task task) {
        repo.save(task);
    }

    public void deleteTaskById(int id) {
        repo.deleteById(id);
    }

    public void nukeTasks() {
        repo.deleteAll();
    }
}
