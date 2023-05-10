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

@WebServlet("/putServlet")
public class PutServlet extends HttpServlet {
    /**
     * @author Viacheslav Korbut
     * Remove PrintWriter.
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setEmail(email);
        employee.setCountry(country);

        int status = EmployeeRepository.update(employee);
        try (PrintWriter out = response.getWriter()) {
            if (status > 0) {
                out.print("You update user from id: " + id + " to user: " + employee);
            } else {
                out.print("Such a user does not exist!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
