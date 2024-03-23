package dev.micfro.weeklyquicklylight.controller;

import dev.micfro.weeklyquicklylight.model.Authority;
import dev.micfro.weeklyquicklylight.model.Customer;
import dev.micfro.weeklyquicklylight.model.User;
import dev.micfro.weeklyquicklylight.service.CustomerService;
import dev.micfro.weeklyquicklylight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    UserService userService;
    CustomerService customerService;
    PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerController(UserService userService, PasswordEncoder passwordEncoder, CustomerService customerService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.customerService = customerService;


        customerService.createCustomer(
                "customer",
                "$2a$12$rPHndWTGg.zzfwwIB.797ugF/Wnd1ABv.juxwC06sWDDWH07omOBq",
                "Julian",
                "Frost");
    }

    @GetMapping("/customer-form")
    public String showCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/add-customer")
    public String addCustomer(@ModelAttribute("customer") Customer customer) {
        // PasswordEncoder
        User user = customer.getUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setAuthority(new Authority(user.getUsername(), "ROLE_CUSTOMER"));

        // Save Customer
        customerService.saveCustomer(customer);


        return "redirect:/customer-list";
    }
}





