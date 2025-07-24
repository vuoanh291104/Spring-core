package org.example.dao;

import org.example.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDAO {
    private final JdbcTemplate jdbcTemplate;

    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void save(User user) {
        jdbcTemplate.update("INSERT INTO users (id, name) VALUES (?, ?)",
                user.getId(), user.getName());
    }

    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users",
                (rs, rowNum) -> new User(rs.getInt("id"), rs.getString("name")));
    }
}
