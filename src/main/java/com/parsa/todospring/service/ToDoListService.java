package com.parsa.todospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parsa.todospring.model.ToDoList;
import com.parsa.todospring.repository.ToDoListRepository;

@Service
public class ToDoListService {

    private ToDoListRepository toDoListRepository;

    public ToDoListRepository getToDoListRepository() {
        return toDoListRepository;
    }

    @Autowired
    public void setToDoListRepository(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public void createToDoList(ToDoList toDoList) {
        toDoListRepository.createToDoList(toDoList);
    }

    
    
}
