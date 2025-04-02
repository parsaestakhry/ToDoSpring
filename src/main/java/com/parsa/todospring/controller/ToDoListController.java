package com.parsa.todospring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parsa.todospring.model.ToDoList;
import com.parsa.todospring.service.ToDoListService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/todolist")
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;

    @PostMapping("/createlist")
    public void createToDoList(@RequestBody ToDoList toDoList) {
        toDoListService.createToDoList(toDoList);
    }

    @GetMapping("/getlists")
    public List<ToDoList> getToDoLists() {
        return toDoListService.getToDoLists();
    }

    @GetMapping("/getlist/{id}")
    public ToDoList getToDoList(@PathVariable int id) {
        return toDoListService.getToDoList(id);
    }

    @PutMapping("/updatelist/{id}")
    public ToDoList updateToDoList(@RequestBody ToDoList toDoList) {
        return toDoListService.updateToDoList(toDoList);
    }

    @DeleteMapping("/deletelist/{id}")
    public boolean deleteToDoList(@PathVariable int id) {
        return toDoListService.deleteToDoList(id);
    }
    





    
    
}
