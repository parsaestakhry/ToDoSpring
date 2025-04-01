package com.parsa.todospring.repository;

import com.parsa.todospring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public void saveUser(User user) {
        String sql = "INSERT INTO users(id, username, email, password_hash, created_at) VALUES (?,?,?,?,?);";
        int rows = jdbcTemplate.update(sql,
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword_hash(),
                user.getCreated_at());

        System.out.println("rows affected : " + rows);
    }

    public List<User> getUsers() {
        String sql = "SELECT * FROM users;";
        RowMapper<User> mapper = (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setEmail(rs.getString("email"));
            user.setCreated_at(rs.getDate("created_at"));
            user.setUsername(rs.getString("username"));
            user.setPassword_hash(rs.getString("password_hash"));

            return user;
        };

        return jdbcTemplate.query(sql, mapper);
    }

    public User getUser(int id) {
        String sql = "SELECT * FROM users WHERE id = ?;";
        RowMapper<User> mapper = (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setEmail(rs.getString("email"));
            user.setCreated_at(rs.getDate("created_at"));
            user.setUsername(rs.getString("username"));
            user.setPassword_hash(rs.getString("password_hash"));
            return user;
        };
        return jdbcTemplate.queryForObject(sql, mapper, id);
    }

    public User updateUser(User updatedUser) {
        String sql = "UPDATE users SET username = ?, email = ?, password_hash = ? WHERE id = ?;";
        int rows = jdbcTemplate.update(sql,
                updatedUser.getUsername(),
                updatedUser.getEmail(),
                updatedUser.getPassword_hash(),
                updatedUser.getId());

        System.out.println("rows affected : " + rows);

        return getUser(updatedUser.getId()); // Return the updated user
    }

    public Boolean deleteUser(int id) {

        String sql = "DELETE FROM users WHERE id = ?;";
        int rows = jdbcTemplate.update(sql, id);
        return rows > 0;
        
    }

}
