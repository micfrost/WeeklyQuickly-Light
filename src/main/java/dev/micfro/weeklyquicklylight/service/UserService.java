package dev.micfro.weeklyquicklylight.service;

import dev.micfro.weeklyquicklylight.model.Authority;
import dev.micfro.weeklyquicklylight.model.User;
import dev.micfro.weeklyquicklylight.repository.AuthorityRepository;
import dev.micfro.weeklyquicklylight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    @Autowired
    public UserService(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;

        this.authorityRepository = authorityRepository;
    }

    // CRUD

    // save user
    public void saveUser(User user) {
        userRepository.save(user);
    }



    public User createUser(String username, String password, String authorityRole) {
        Authority authority = new Authority(username, authorityRole);

        User user = new User(username, password, true, authority);
        return userRepository.save(user); // Save and return the user
    }

    // Read
    public List<User> findAll() {
        return userRepository.findAll();
    }

}