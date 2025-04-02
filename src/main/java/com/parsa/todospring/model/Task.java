package com.parsa.todospring.model;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Task {
    private int id;
    private int list_id;
    private Date created_at;
    private String title;
    private String description;
    private boolean is_completed;
    private Date due_date;
    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getList_id() {
        return list_id;
    }
    public void setList_id(int list_id) {
        this.list_id = list_id;
    }
    public Date getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isIs_completed() {
        return is_completed;
    }
    public void setIs_completed(boolean is_completed) {
        this.is_completed = is_completed;
    }
    @Override
    public String toString() {
        return "Task [id=" + id + ", list_id=" + list_id + ", created_at=" + created_at + ", title=" + title
                + ", description=" + description + ", is_completed=" + is_completed + "]";
    }
    public Date getDue_date() {
        return due_date;
    }
    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }


    

}
