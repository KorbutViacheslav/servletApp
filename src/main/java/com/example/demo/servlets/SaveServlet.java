package com.example.demo.servlets;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/saveServlet")
public class SaveServlet extends HttpServlet {
    /**
     * @author Viacheslav Korbut
     * Remove PrintWriter.
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setCountry(country);

        EmployeeRepository.save(employee);
        response.sendRedirect("viewServlet");
    }
}
