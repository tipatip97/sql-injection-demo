package ru.fiztech.sqlinjection.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.fiztech.sqlinjection.entity.User;

@Service
public class UserService {
    private JdbcTemplate jdbcTemplate;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User login(String login, String password) {
        return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE LOGIN = '" + login + "' AND PASSWORD = '" + password + "'", (rs, rowNum) ->
                new User(rs.getLong("id"), rs.getString("login"), rs.getString("password"), rs.getString("full_name")));
    }
}
