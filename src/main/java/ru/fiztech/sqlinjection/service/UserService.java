package ru.fiztech.sqlinjection.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.fiztech.sqlinjection.entity.User;
import ru.fiztech.sqlinjection.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private JdbcTemplate jdbcTemplate;

    public UserService(UserRepository userRepository, JdbcTemplate jdbcTemplate) {
        this.userRepository = userRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public User login(String login, String password) {
        return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE login = '" + login + "' AND password = '" + password + "'", (rs, rowNum) ->
                new User(rs.getLong("id"), rs.getString("login"), rs.getString("password"), rs.getString("full_name")));
    }
}
