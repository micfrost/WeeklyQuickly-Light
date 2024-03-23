package dev.micfro.weeklyquicklylight.service;

import dev.micfro.weeklyquicklylight.model.Authority;
import dev.micfro.weeklyquicklylight.model.Customer;
import dev.micfro.weeklyquicklylight.model.User;
import dev.micfro.weeklyquicklylight.repository.AuthorityRepository;
import dev.micfro.weeklyquicklylight.repository.CustomerRepository;
import dev.micfro.weeklyquicklylight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, UserRepository userRepository) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
    }

    // CRUD

    // save Customer
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }


    public User createCustomer(
            String username,
            String password,
            String firstName,
            String lastName) {
        Customer customer = new Customer(firstName, lastName);
        Authority authority = new Authority(username, customer.getRole());
        User user = new User(username, password, true, authority, customer);
        userRepository.save(user);

        return user;
    }

    // Read
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }




}


