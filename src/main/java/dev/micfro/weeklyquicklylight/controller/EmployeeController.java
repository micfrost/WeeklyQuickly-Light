package dev.micfro.weeklyquicklylight.controller;

import dev.micfro.weeklyquicklylight.model.Authority;
import dev.micfro.weeklyquicklylight.model.Employee;
import dev.micfro.weeklyquicklylight.model.User;
import dev.micfro.weeklyquicklylight.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    EmployeeService employeeService;
    PasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeController(PasswordEncoder passwordEncoder, EmployeeService employeeService) {

        this.passwordEncoder = passwordEncoder;
        this.employeeService = employeeService;
    }

    @GetMapping("/employee-list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employeeService.findAll());
        return "employee-list";
    }

    @GetMapping("/employee-form")
    public String showEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping("/add-employee")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        // PasswordEncoder
        User user = employee.getUser();
        user.setEmployee(employee);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setAuthority(new Authority(user.getUsername(), employee.getRole()));
        // Save Employee
        employeeService.saveEmployee(employee);
        return "redirect:/employee-list";
    }
}