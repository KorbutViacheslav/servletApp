package com.example.demo;

import com.example.demo.config.DatabaseConfigInit;

public class Main {
    public static void main(String[] args) {
/*        getConnection();

        Employee employee = new Employee();

        employee.setName("aaaaaaaaaaaaaaaa");
        employee.setEmail("new@gmail.com");
        employee.setCountry("canada");
        save(employee);*/
        System.out.println(DatabaseConfigInit.getUrl());
        System.out.println(DatabaseConfigInit.getUser());
        System.out.println(DatabaseConfigInit.getPassword());
    }
}
