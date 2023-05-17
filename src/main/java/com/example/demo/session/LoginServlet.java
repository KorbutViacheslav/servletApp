package com.example.demo.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Это название 2-х параметров, которые мы передаем
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        // Это значение наших параметров
        Map<String,String> admin=new HashMap<>();
        admin.put("admin","password");
        PrintWriter out = response.getWriter();

        if (admin.containsKey(user) && admin.get(user).equals(pwd)) {
            /*HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            //setting session to expiry in 30 mins
            int sessionTimeoutInSeconds = 30 * 60;
            session.setMaxInactiveInterval(sessionTimeoutInSeconds);*/
            Cookie userName = new Cookie("user", user);
            userName.setMaxAge(30*60);
            response.addCookie(userName);
            out.println("Welcome back to the team, " + user + "!");
        } else {
            out.println("Either user name or password is wrong!");
        }
    }
}