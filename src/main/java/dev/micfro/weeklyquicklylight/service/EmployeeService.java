package dev.micfro.weeklyquicklylight.service;

import dev.micfro.weeklyquicklylight.model.Authority;
import dev.micfro.weeklyquicklylight.model.Employee;
import dev.micfro.weeklyquicklylight.model.User;
import dev.micfro.weeklyquicklylight.repository.AuthorityRepository;
import dev.micfro.weeklyquicklylight.repository.EmployeeRepository;
import dev.micfro.weeklyquicklylight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, UserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
    }

    // CRUD

    // save Employee
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }


    public User createEmployee(
            String username,
            String password,
            String firstName,
            String lastName) {
        Employee employee = new Employee(firstName, lastName);
        Authority authority = new Authority(username, employee.getRole());
        User user = new User(username, password, true, authority, employee);
        userRepository.save(user);

        return user;
    }

    // Read
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }




}


