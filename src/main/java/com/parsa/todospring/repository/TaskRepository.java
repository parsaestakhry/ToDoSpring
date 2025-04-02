package com.parsa.todospring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

    public List<Task> getTasks() {
        String sql = "SELECT * FROM tasks;";
        RowMapper<Task> mapper = (rs, rowNum) -> {
            Task task = new Task();
            task.setCreated_at(rs.getDate("created_at"));
            task.setDescription(rs.getString("description"));
            task.setDue_date(rs.getDate("due_date"));
            task.setId(rs.getInt("id"));
            task.setIs_completed(rs.getBoolean("is_completed"));
            task.setTitle(rs.getString("title"));
            return task;
        };

        return jdbcTemplate.query(sql, mapper);

    }

}
