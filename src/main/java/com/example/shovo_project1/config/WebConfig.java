package com.example.shovo_project1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.shovo_project1.middleware.AuthenticationInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer
{
    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    @SuppressWarnings("null")
    @Override 
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/api/**");
    }
}
