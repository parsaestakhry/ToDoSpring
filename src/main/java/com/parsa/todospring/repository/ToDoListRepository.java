package com.parsa.todospring.repository;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
        int rows = jdbcTemplate.update(sql, todolist.getName(), todolist.getCreated_at(), todolist.getId(),
                todolist.getUser_id());
        System.out.println("Rows Affected:" + rows);
    }
    
    public List<ToDoList> getToDolists() {
        String sql = "SELECT * FROM todo_lists";
        RowMapper<ToDoList> mapper = (rs, rowNum) -> {
            ToDoList todolist = new ToDoList();
            todolist.setId(rs.getInt("id"));
            todolist.setCreated_at(rs.getDate("created_at"));
            todolist.setName(rs.getString("name"));
            todolist.setUser_id(rs.getInt("user_id"));
            return todolist;
        };

        return jdbcTemplate.query(sql, mapper);
    }


    public ToDoList geToDoList(int id) {
        String sql = "SELECT * FROM todo_lists WHERE id = ?;";
        RowMapper<ToDoList> mapper = (rs,rowNum) -> {
            ToDoList toDoList = new ToDoList();
            toDoList.setId(rs.getInt("id"));
            toDoList.setCreated_at(rs.getDate("created_at"));
            toDoList.setName(rs.getString("name"));
            toDoList.setUser_id(rs.getInt("user_id"));
            return toDoList;

        };
        return jdbcTemplate.queryForObject(sql, mapper, id);
    }

}
