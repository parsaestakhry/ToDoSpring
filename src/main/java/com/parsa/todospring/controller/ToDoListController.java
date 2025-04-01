package com.parsa.todospring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parsa.todospring.model.ToDoList;
import com.parsa.todospring.service.ToDoListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/todolist")
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;

    @PostMapping("/createlist")
    public void createToDoList(@RequestBody ToDoList toDoList) {
        toDoListService.createToDoList(toDoList);
    }

    
    
}
