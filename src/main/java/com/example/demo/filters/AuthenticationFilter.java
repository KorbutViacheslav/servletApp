package com.example.demo.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import static com.example.demo.config.UrlPath.*;

@WebFilter("/demo/*")
public class AuthenticationFilter implements Filter {
    public static final Set<String> PUBLIC_PATH = Set.of(LOGIN,LOGOUT,DELETE,SAVE,VIEW_ALL,VIEW_ID,PUT);

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log(">>> AuthenticationFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        this.context.log("Requested Resource::http://localhost:8080" + uri);

        HttpSession session = req.getSession(false);

        accessOrNo(request, response, chain, res, uri, session);
    }

    private void accessOrNo(ServletRequest request, ServletResponse response, FilterChain chain, HttpServletResponse res, String uri, HttpSession session) throws IOException, ServletException {
        if (session == null && !PUBLIC_PATH.contains(uri)) {
            this.context.log("<<< Unauthorized access request");
            PrintWriter out = res.getWriter();
            out.println("No access!!!(AuthenticationFilter)");
        } else {
            chain.doFilter(request, response);
        }
    }
}
