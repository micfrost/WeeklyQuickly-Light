package dev.micfro.weeklyquicklylight.controller;

import dev.micfro.weeklyquicklylight.model.Authority;
import dev.micfro.weeklyquicklylight.model.User;
import dev.micfro.weeklyquicklylight.repository.AuthorityRepository;
import dev.micfro.weeklyquicklylight.service.AuthorityService;
import dev.micfro.weeklyquicklylight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @Autowired
    public HomeController(UserService userService, AuthorityService authorityService, AuthorityRepository authorityRepository) {

    }


    @GetMapping("/")
    public String home() {
        return "home";
    }


}