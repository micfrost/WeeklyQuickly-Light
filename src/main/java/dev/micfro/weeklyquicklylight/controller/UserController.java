package dev.micfro.weeklyquicklylight.controller;

import dev.micfro.weeklyquicklylight.model.Authority;
import dev.micfro.weeklyquicklylight.model.User;
import dev.micfro.weeklyquicklylight.service.AuthorityService;
import dev.micfro.weeklyquicklylight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class UserController {

    UserService userService;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;

        userService.createUser(
                "admin",
                "$2a$12$H5schs/Xb6ICj4pEZA6mrOrQRV/6vfEGqHtCCkYwUAmU8vtbJcTce",
                "ROLE_ADMIN");
    }


    @GetMapping("/user-list")
    public String listUsers(Model model) {

        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-form")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute("user") User user) {
        // PasswordEncoder
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setAuthority(new Authority(user.getUsername(), "ROLE_ADMIN"));

        // Save the user
        userService.saveUser(user);


        return "redirect:/user-list";
    }
}
