package com.parsa.todospring.model;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ToDoList {
    private String name;
    private Date created_at;
    private int id;
    private int user_id;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    @Override
    public String toString() {
        return "ToDoList [name=" + name + ", created_at=" + created_at + ", id=" + id + ", user_id=" + user_id + "]";
    }
    
    

    
    
}
