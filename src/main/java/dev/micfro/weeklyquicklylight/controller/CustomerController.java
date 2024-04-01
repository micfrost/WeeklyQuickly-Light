package dev.micfro.weeklyquicklylight.controller;

import dev.micfro.weeklyquicklylight.model.Authority;
import dev.micfro.weeklyquicklylight.model.Customer;
import dev.micfro.weeklyquicklylight.model.User;
import dev.micfro.weeklyquicklylight.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {

    CustomerService customerService;
    PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerController(PasswordEncoder passwordEncoder, CustomerService customerService) {

        this.passwordEncoder = passwordEncoder;
        this.customerService = customerService;
    }


    @GetMapping("/customer-list")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customerService.findAll());
        return "customer-list";
    }

    @GetMapping("/customer-form")
    public String getCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/add-customer")
    public String addCustomer(@ModelAttribute("customer") Customer customer) {
        // PasswordEncoder
        User user = customer.getUser();
        user.setCustomer(customer);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setAuthority(new Authority(user.getUsername(), customer.getRole()));
        // Save Customer
        customerService.save(customer);
        return "redirect:/customer-list";
    }
}