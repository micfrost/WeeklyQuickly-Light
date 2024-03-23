package dev.micfro.weeklyquicklylight.service;

import dev.micfro.weeklyquicklylight.model.Authority;
import dev.micfro.weeklyquicklylight.model.Admin;
import dev.micfro.weeklyquicklylight.model.User;
import dev.micfro.weeklyquicklylight.repository.AdminRepository;
import dev.micfro.weeklyquicklylight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository, UserRepository userRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
    }

    // CRUD

    // save Admin
    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }


    public User createAdmin(
            String username,
            String password,
            String firstName,
            String lastName) {
        Admin admin = new Admin(firstName, lastName);
        Authority authority = new Authority(username, admin.getRole());
        User user = new User(username, password, true, authority, admin);
        userRepository.save(user);

        return user;
    }

    // Read
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }




}


