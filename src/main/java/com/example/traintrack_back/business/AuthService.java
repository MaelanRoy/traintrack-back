package com.example.traintrack_back.business;

import org.springframework.validation.annotation.Validated;

import com.example.traintrack_back.api.models.AuthResponseDto;
import com.example.traintrack_back.api.models.LoginRequestDto;
import com.example.traintrack_back.api.models.RegisterRequestDto;

import jakarta.validation.Valid;

/**
 * Service interface for authentication operations
 */
@Validated
public interface AuthService {

    /**
     * Register a new user
     * 
     * @param registerRequest Registration data
     * @return Authentication response with token and user info
     * @throws RuntimeException if email already exists or registration fails
     */
    AuthResponseDto register(@Valid RegisterRequestDto registerRequest);

    /**
     * Authenticate user and generate JWT token
     * 
     * @param loginRequest Login credentials
     * @return Authentication response with token and user info
     * @throws RuntimeException if authentication fails
     */
    AuthResponseDto login(@Valid LoginRequestDto loginRequest);
}
