package com.parsa.todospring.service;


import com.parsa.todospring.model.User;
import com.parsa.todospring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user){
        userRepository.saveUser(user);
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }
    
    public User getUser(int id) {
        return userRepository.getUser(id);
    }
}
