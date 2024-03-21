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
public class LoginController {


    private final UserService userService;
    private final AuthorityService authorityService;
    private final AuthorityRepository authorityRepository;

    @Autowired
    public LoginController(UserService userService, AuthorityService authorityService, AuthorityRepository authorityRepository) {
        this.userService = userService;
        this.authorityService = authorityService;
        this.authorityRepository = authorityRepository;

        // username=admin Password=pass123
        User firstAdmin = new User();
        firstAdmin.setUsername("admin");
        firstAdmin.setPassword("{bcrypt}$2a$12$m07YE2CBQq0UIzfAF.mgSeDYlM5m8xt5M0sDdXtUDkJUgr2EdKUxq");
        firstAdmin.setEnabled(true);

        userService.saveUser(firstAdmin);

        Authority adminAuthority = new Authority();
        adminAuthority.setUsername("admin");
        adminAuthority.setAuthority("ROLE_ADMIN");
        authorityService.saveAuthority(adminAuthority);
        // pass123
    }

    @GetMapping("/login")
    public String login() {
        return "login-page";
    }

}


