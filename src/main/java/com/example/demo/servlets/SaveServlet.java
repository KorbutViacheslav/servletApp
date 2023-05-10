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

@WebServlet("/saveServlet")
public class SaveServlet extends HttpServlet {
    /**
     * @author Viacheslav Korbut
     * Remove PrintWriter.
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{

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

        try (PrintWriter out=response.getWriter()){
            out.print("You created new user: "+employee);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
