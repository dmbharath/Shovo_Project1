package com.example.shovo_project1.middleware;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor
{
    // @Override 
    public boolean perHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception 
    {
        String authToken = request.getHeader("Authorization");
        if(authToken == null || !authToken.equals("Valid token"))
        {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized : Invalid or missing token");
            return false;
        }
        return true;
    }
}
