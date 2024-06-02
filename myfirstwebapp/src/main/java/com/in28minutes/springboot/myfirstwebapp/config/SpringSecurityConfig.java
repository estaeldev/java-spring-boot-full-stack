package com.in28minutes.springboot.myfirstwebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails1 = User.builder()
            .username("estael")
            .password("1234")
            .roles("USER", "ADMIN")
            .passwordEncoder(password -> passwordEncoder().encode(password))
            .build();
        
        UserDetails userDetails2 = User.builder()
            .username("tael")
            .password("1234")
            .roles("USER", "ADMIN")
            .passwordEncoder(password -> passwordEncoder().encode(password))
            .build();

        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    
}
