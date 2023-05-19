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

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        Map<String, String> admin = new HashMap<>();
        admin.put("admin", "password");

        logOrNo(request, response, user, pwd, admin);
    }
    private static void logOrNo(HttpServletRequest request, HttpServletResponse response, String user, String pwd, Map<String, String> admin) throws IOException {
        PrintWriter out = response.getWriter();
        if (admin.containsKey(user) && admin.get(user).equals(pwd)) {
            int timeoutInSeconds = 30 * 60;
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(timeoutInSeconds);
            Cookie userName = new Cookie("user", user);
            userName.setMaxAge(30 * 60);
            response.addCookie(userName);
            out.println("Welcome back to the team, " + user + "!");
        } else {
            out.println("Either user name or password is wrong!");
        }
    }
}