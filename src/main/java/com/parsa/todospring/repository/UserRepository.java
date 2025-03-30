package com.parsa.todospring.repository;


import com.parsa.todospring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveUser(User user){
        String sql = "INSERT INTO users(id, username, email, password_hash, created_at) VALUES (?,?,?,?,?);";
        int rows = jdbcTemplate.update(sql,
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword_hash(),
                user.getCreated_at());

        System.out.println("rows affected : " + rows);
    }




}
