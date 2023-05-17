package com.example.demo;


import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

import java.util.Set;

import static com.example.demo.repository.EmployeeRepository.getConnection;
import static com.example.demo.repository.EmployeeRepository.save;

public class Main {
    public static void main(String[] args) {
/*        getConnection();

        Employee employee = new Employee();

        employee.setName("aaaaaaaaaaaaaaaa");
        employee.setEmail("new@gmail.com");
        employee.setCountry("canada");
        save(employee);*/

        getConnection();
        EmployeeRepository.getAllEmployees().forEach(System.out::println);
        EmployeeRepository.delete(21);
        EmployeeRepository.getAllEmployees().forEach(System.out::println);

    }
}
