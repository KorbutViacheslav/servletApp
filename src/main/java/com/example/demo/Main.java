package com.example.demo;


import com.example.demo.entity.Employee;

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

        final Set<String> PUBLIC_PATH = Set.of("demo/logoutServlet",
                "demo/deleteServlet",
                "demo/saveServlet",
                /*"demo/viewByIDServlet",*/
                "demo/loginServlet",
                "demo/viewServlet");
        String uri="demo/saveServle";
        String a= PUBLIC_PATH.stream().filter(uri::startsWith).findFirst().orElse("");
        System.out.println(a);
        System.out.println(uri);
    }
}
