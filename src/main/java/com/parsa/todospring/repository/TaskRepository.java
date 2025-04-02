package com.parsa.todospring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.parsa.todospring.model.Task;

@Repository
public class TaskRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void createTask(Task task) {
        String sql = "INSERT INTO tasks(title, description, is_completed, due_date, created_at) VALUES (?, ?, ?, ?, ?);";
        int rows = jdbcTemplate.update(sql, task.getTitle(), task.getDescription(), task.isIs_completed(),
                task.getDue_date(), task.getCreated_at());
        System.out.println("rows affected: " + rows);
    }

}
