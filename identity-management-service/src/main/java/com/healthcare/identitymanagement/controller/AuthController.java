package com.healthcare.identitymanagement.controller;

import com.healthcare.identitymanagement.service.AuthService;
import com.healthcare.identitymanagement.service.dto.JwtTokenDto;
import com.healthcare.identitymanagement.service.dto.LoginRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AuthController {
    @Autowired
    private AuthService service;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest) {
        var loginResponse = service.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public JwtTokenDto refreshToken(@RequestBody JwtTokenDto refreshTokenRequest){
        return service.refreshToken(refreshTokenRequest);
    }
}
