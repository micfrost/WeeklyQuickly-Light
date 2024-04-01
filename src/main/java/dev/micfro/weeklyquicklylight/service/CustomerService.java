package dev.micfro.weeklyquicklylight.service;

import dev.micfro.weeklyquicklylight.model.Authority;
import dev.micfro.weeklyquicklylight.model.Customer;
import dev.micfro.weeklyquicklylight.model.User;


import dev.micfro.weeklyquicklylight.repository.CustomerRepository;
import dev.micfro.weeklyquicklylight.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public CustomerService(CustomerRepository customerRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // init Data
    @PostConstruct
    public void initCustomers() {
        String username = "customerjulian";
        String password = passwordEncoder.encode(username);
        createCustomer(
                username,
                password,
                "Julian",
                "Frost");
    }


// CRUD

    // save Customer
    public void save(Customer customer) {
        customerRepository.save(customer);
    }


    public void createCustomer(
            String username,
            String password,
            String firstName,
            String lastName) {
        Customer customer = new Customer(firstName, lastName);
        Authority authority = new Authority(username, customer.getRole());
        User user = new User(username, password, true, authority, customer);
        userRepository.save(user);
    }

    // Read
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer findById(Integer id) {
        return customerRepository.findById(Long.valueOf(id)).orElse(null);
    }


}


