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
 
     // @Bean
     // UserDetailsService userDetailsService(){
     // return new InMemoryUserDetailsManager(List.of(
     // User
     // .withUsername("joao")
     // .password("$2a$12$bTQhrOKvy8u.41Z6MCtAWO324bULDah.LrXdFZ/aWkS9gY0UYRS0G")
     // .roles("ADMIN")
     // .build(),
     // User
     // .withUsername("maria")
     // .password("$2a$12$nuQqQOe3hA5jWi4bCWQ8bedArKPWo45Mvv1n2kulO/r7AjMwJHxvm")
     // .roles("USER")
     // .build()
     // ));
     // }
 
     @Bean
     PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }
 
 }