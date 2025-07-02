package com.example.traintrack_back.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.traintrack_back.api.models.LoginRequestDto;
import com.example.traintrack_back.api.models.RegisterRequestDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Endpoints for user authentication operations
 */
@RequestMapping("/api/auth")
@Tag(name = "Authentication")
@Validated
public interface AuthController {

    /**
     * Register a new user
     * 
     * @param registerRequest Registration data
     * @return Response entity with authentication data or error
     */
    @PostMapping("/register")
    @Operation(summary = "Register a new user", description = "Create a new user account with email, username and password")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User registered successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data or email already exists"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<?> register(@Valid @RequestBody RegisterRequestDto registerRequest);

    /**
     * Authenticate user and get JWT token
     * 
     * @param loginRequest Login credentials
     * @return Response entity with authentication data or error
     */
    @PostMapping("/login")
    @Operation(summary = "User login", description = "Authenticate user with email and password, returns JWT token")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User authenticated successfully"),
        @ApiResponse(responseCode = "401", description = "Invalid credentials"),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto loginRequest);
}
