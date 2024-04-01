package dev.micfro.weeklyquicklylight.service;

import dev.micfro.weeklyquicklylight.model.Authority;
import dev.micfro.weeklyquicklylight.model.Admin;
import dev.micfro.weeklyquicklylight.model.User;
import dev.micfro.weeklyquicklylight.repository.AdminRepository;
import dev.micfro.weeklyquicklylight.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    AdminRepository adminRepository;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public AdminService(AdminRepository adminRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // init data
    @PostConstruct
    public void init() {
        // password = username
        String username = "adminmichal";
        String password = passwordEncoder.encode(username);
        createAdmin(
                username,
                password,
                "Michal",
                "Frost");
    }


    // CRUD

    // save Admin
    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }


    public void createAdmin(
            String username,
            String password,
            String firstName,
            String lastName) {
        Admin admin = new Admin(firstName, lastName);
        Authority authority = new Authority(username, admin.getRole());
        User user = new User(username, password, true, authority, admin);
        userRepository.save(user);

    }

    // Read
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }


}


