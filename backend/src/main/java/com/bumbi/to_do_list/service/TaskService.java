package com.bumbi.to_do_list.service;

import com.bumbi.to_do_list.model.Task;
import com.bumbi.to_do_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List <Task> getAllTasks() {
        return repo.findAll();
    }

    public Task getClosestTaskToDueDate() {
        Task closestTask = repo.findAll().getFirst();

        for(Task task : repo.findAll())
            if(task.getDueDate().getTime() < closestTask.getDueDate().getTime())
                closestTask = task;

        return closestTask;
    }

    public void addTask(Task task) {
        repo.save(task);
    }

    public void updateTask(Task newTask) {
        if(repo.findById(newTask.getId()).isEmpty())
            return;

        Task oldTask = repo.findById(newTask.getId()).get();
        oldTask.setDesc(newTask.getDesc());
        oldTask.setColor(newTask.getColor());
        oldTask.setDueDate(newTask.getDueDate());
        oldTask.setCreationDate(newTask.getCreationDate());

        repo.save(oldTask);
    }

    public void deleteTaskById(int id) {
        repo.deleteById(id);
    }

    public void nukeTasks() {
        repo.deleteAll();
        String sql = "ALTER TABLE task AUTO_INCREMENT = 1";
        jdbcTemplate.execute(sql);
    }
}
