package com.example.traintrack_back.api.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.traintrack_back.api.AuthController;
import com.example.traintrack_back.api.models.AuthResponseDto;
import com.example.traintrack_back.api.models.LoginRequestDto;
import com.example.traintrack_back.api.models.RegisterRequestDto;
import com.example.traintrack_back.business.AuthService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementation of {@link AuthController}
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthControllerImpl implements AuthController {

    private final AuthService authService;

    /**
     * Register a new user
     * 
     * @param registerRequest Registration data
     */
    @Override
    public ResponseEntity<?> register(RegisterRequestDto registerRequest) {
        try {
            AuthResponseDto response = authService.register(registerRequest);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            log.error("Registration failed: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Authenticate user and get JWT token
     * 
     * @param loginRequest Login credentials
     */
    @Override
    public ResponseEntity<?> login(LoginRequestDto loginRequest) {
        try {
            AuthResponseDto response = authService.login(loginRequest);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            log.error("Login failed: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
