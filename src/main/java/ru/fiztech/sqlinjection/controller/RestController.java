package ru.fiztech.sqlinjection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.fiztech.sqlinjection.entity.User;
import ru.fiztech.sqlinjection.service.UserService;

@org.springframework.web.bind.annotation.RestController("/")
public class RestController {
    private final UserService userService;

    public RestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    private User get_user(@RequestParam String login, @RequestParam String password) {
        return userService.login(login, password);
    }
}
