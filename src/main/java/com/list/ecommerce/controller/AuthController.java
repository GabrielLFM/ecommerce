package com.list.ecommerce.controller;

import com.list.ecommerce.DTOs.request.LoginRequest;
import com.list.ecommerce.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthController {

    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    public AuthController(JwtService jwtService, AuthenticationManager authManager) {
        this.jwtService = jwtService;
        this.authManager = authManager;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getSenha()
                )
        );
        return jwtService.gerarToken(request.getEmail());
    }

}
