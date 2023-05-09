package com.example.demo;

import static com.example.demo.EmployeeRepository.getConnection;
import static com.example.demo.EmployeeRepository.save;

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
