package com.example.demo.servlets;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/viewServlet")
public class ViewServlet extends HttpServlet {
    /**
     * @author Viacheslav Korbut
     * Used the foreach method to output the list of employees.
     * Also, to automatically close PrintWriter, used try-with-resources.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        List<Employee> list = EmployeeRepository.getAllEmployees();

        try (PrintWriter out = response.getWriter()) {
            list.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
