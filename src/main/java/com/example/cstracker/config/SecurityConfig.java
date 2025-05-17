package com.example.cstracker.config;
 
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.http.HttpMethod;
 import org.springframework.security.config.Customizer;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.security.web.SecurityFilterChain;
 
 @Configuration
 public class SecurityConfig {
 
     @Bean
     SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         return http
                 .authorizeHttpRequests(auth -> auth
                         .requestMatchers("/players/**").hasRole("ADMIN")
                         .requestMatchers(HttpMethod.POST, "/users/**").permitAll()
                         .anyRequest().authenticated())
                 .httpBasic(Customizer.withDefaults())
                 .csrf(csrf -> csrf.disable())
                 .build();
     }
     @Bean
     PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }
 
 }