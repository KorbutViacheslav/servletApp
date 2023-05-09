package com.example.demo.servlets;


import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/viewByIDServlet")
public class ViewByIDServlet extends HttpServlet {
    /**
     * @author Viacheslav Korbut
     * Automatically close PrintWriter, used try-with-resources.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            String sid = request.getParameter("id");
            int id = Integer.parseInt(sid);

            Employee employee = EmployeeRepository.getEmployeeById(id);

            out.print(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
