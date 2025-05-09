package com.example.cstracker.Controller;
 
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 
 import com.example.cstracker.model.User;
 import com.example.cstracker.repository.UserRepository;
 import jakarta.validation.Valid;
 
 @RestController
 @RequestMapping("/users")
 public class UserController {
 
     @Autowired
     private UserRepository repository;
 
     @Autowired
     private PasswordEncoder passwordEncoder;
 
     @PostMapping
     public User create(@RequestBody @Valid User user) {
         user.setPassword(passwordEncoder.encode(user.getPassword()));
         return repository.save(user);
     }
 
 }