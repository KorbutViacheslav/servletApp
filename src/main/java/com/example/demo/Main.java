package com.example.demo;

import com.example.demo.entity.Employee;

import static com.example.demo.repository.EmployeeRepository.getConnection;
import static com.example.demo.repository.EmployeeRepository.save;

public class Main {
    public static void main(String[] args) {
        getConnection();

        Employee employee = new Employee();

        employee.setName("sam");
        employee.setEmail("new@gmail.com");
        employee.setCountry("canada");
        save(employee);
    }
}
