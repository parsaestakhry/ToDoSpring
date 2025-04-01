package com.parsa.todospring.controller;


import com.parsa.todospring.model.User;
import com.parsa.todospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/adduser")
    public void addUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @GetMapping("/getusers")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/getuser/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }
    
    @PutMapping("/updateuser")
    public User updateUser(@RequestBody User updatedUser) {
        return userService.updateUser(updatedUser);
    }

    @DeleteMapping("/deleteuser/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }


    



    

}
