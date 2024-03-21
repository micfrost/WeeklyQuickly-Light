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

    private final UserService userService;
    private final AuthorityService authorityService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, AuthorityService authorityService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.authorityService = authorityService;
        this.passwordEncoder = passwordEncoder;

        // username=admin Password=pass123

        User user = new User("admin", "$2a$12$WsjTze9HY2zZE6j6bMwplOk03LoT762Win452SbixBEkhhiPbCJBO", true);
        user.setAuthority(new Authority(user.getUsername(), "ROLE_ADMIN"));
        userService.saveUser(user);
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
        user.getPassword();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        user.setAuthority(new Authority(user.getUsername(), "ROLE_ADMIN"));

        // Save the user
        userService.saveUser(user);


        return "redirect:/user-list";
    }
}
