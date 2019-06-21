package ru.fiztech.sqlinjection.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.fiztech.sqlinjection.service.DatabaseService;

@org.springframework.stereotype.Controller("/")
public class MainController {
    private final DatabaseService databaseService;

    public MainController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @GetMapping(value={"", "login"})
    private String login(ModelMap model, @RequestParam(required = false) String login, @RequestParam(required = false) String password) {
        if (login != null && password != null) {
            if (databaseService.login(login, password))
            model.addAttribute("authorized", true);
            return "login";
        }

        model.addAttribute("authorized", false);
        return "login";
    }

    @GetMapping("search")
    private String search(ModelMap modelMap) {
        return "search";
    }

    @GetMapping("search_result")
    private String searchResult(ModelMap modelMap, @RequestParam(name = "search_request") String searchRequest) {
        modelMap.addAttribute("search_result", databaseService.searchBooks(searchRequest));
        return "search_result";
    }
}
