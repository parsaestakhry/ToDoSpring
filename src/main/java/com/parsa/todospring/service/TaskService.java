package com.parsa.todospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parsa.todospring.model.Task;
import com.parsa.todospring.repository.TaskRepository;

@Service
public class TaskService {
    
    
    private TaskRepository taskRepository;

    public TaskRepository getTaskRepository() {
        return taskRepository;
    }

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(Task task) {
        taskRepository.createTask(task);
    }

    public List<Task> getTasks() {
        return taskRepository.getTasks();
    }

    public Task getTask(int id) {
        return taskRepository.getTask(id);
    }


}
