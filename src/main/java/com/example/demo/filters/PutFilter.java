package com.example.demo.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Viacheslav Korbut
 * Implemented log the request details and log the response details.
 */
@WebFilter("/putServlet")
public class PutFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        this.context.log(">>> LoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String requestURI = ((HttpServletRequest) request).getRequestURI();
        this.context.log("Request received for URI:http://localhost:8080" + requestURI);

        chain.doFilter(request, response);

        int statusCode = ((HttpServletResponse) response).getStatus();
        this.context.log("Response status code: " + statusCode);

    }
}
