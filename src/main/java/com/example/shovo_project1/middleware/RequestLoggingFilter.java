package com.example.shovo_project1.middleware;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
@Component
public class RequestLoggingFilter implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {}
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException 
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.println("Incoming request" + httpRequest.getMethod() + " " +httpRequest.getRequestURI());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy()
    {}
    
}
