package com.parsa.todospring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.parsa.todospring.model.ToDoList;

@Repository
public class ToDoListRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createToDoList(ToDoList todolist) {
        String sql = "INSERT INTO todo_lists(name,created_at, id, user_id) VALUES (?, ?, ?, ?)";
        int rows = jdbcTemplate.update(sql, todolist.getName(), todolist.getCreated_at(), todolist.getId(), todolist.getUser_id());
        System.out.println("Rows Affected:" + rows);
    }

}
