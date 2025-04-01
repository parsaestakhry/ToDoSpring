package com.parsa.todospring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.parsa.todospring.model.ToDoList;
import com.parsa.todospring.service.ToDoListService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



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
    


    
    
}
