package com.parsa.todospring.controller;


import com.parsa.todospring.model.User;
import com.parsa.todospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService studentService;



    @PostMapping("/adduser")
    public void addUser(@RequestBody User user){
        studentService.saveUser(user);
    }

    @GetMapping("/getusers")
    public List<User> getUsers(){
        return studentService.getUsers();
    }
}
