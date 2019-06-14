package ru.fiztech.sqlinjection.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.fiztech.sqlinjection.entity.User;

import java.util.List;
import java.util.Map;

@Service
public class DatabaseService {
    private JdbcTemplate jdbcTemplate;

    public DatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Boolean login(String login, String password) {
        return !jdbcTemplate.queryForList("SELECT * FROM USER WHERE LOGIN = '" + login + "' AND PASSWORD = '" + password + "'").isEmpty();
    }

    public List<Map<String, Object>> searchBooks(String searchRequest) {
        return jdbcTemplate.queryForList("SELECT * FROM BOOK WHERE TITLE = '" + searchRequest + "'");
    }
}
