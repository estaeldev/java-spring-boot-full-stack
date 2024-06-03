package com.in28minutes.springboot.myfirstwebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        http.csrf(csrf -> csrf.disable());
        http.headers(header -> header.frameOptions(Customizer.withDefaults()).disable());
        http.formLogin(Customizer.withDefaults());
        
        return http.build();
    }

    
}
