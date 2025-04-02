package com.parsa.todospring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parsa.todospring.model.Task;
import com.parsa.todospring.service.TaskService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping("/createtask")
    public void createtask(@RequestBody Task task) {
        taskService.createTask(task);
    }


    @GetMapping("/gettasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }
    



    
}
