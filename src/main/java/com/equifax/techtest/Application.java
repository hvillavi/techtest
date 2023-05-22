package com.equifax.techtest;

import com.equifax.techtest.model.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootApplication
public class Application {

    @Autowired
    UserDetailsService jwtUserDetailsService;
    @Autowired
    JwtUtil jwtUtil;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public JwtRequestFilter jwtRequestFilter() {
        return new JwtRequestFilter(jwtUtil, jwtUserDetailsService);
    }
}
