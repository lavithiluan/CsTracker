package com.example.cstracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cstracker.services.AuthService;
import com.example.cstracker.services.TokenService;
import com.example.cstracker.model.Credentials;
import com.example.cstracker.model.Token;
import com.example.cstracker.model.User;



@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public Token login(@RequestBody Credentials credentials){
        User user = (User) authService.loadUserByUsername(credentials.email());
        if (!passwordEncoder.matches(credentials.password(), user.getPassword())){
            throw new BadCredentialsException("Senha incorreta");
        }
        return tokenService.createToken(user);
    }
    
}
