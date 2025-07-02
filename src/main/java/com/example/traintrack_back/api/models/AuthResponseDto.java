package com.example.traintrack_back.api.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An authentication response DTO that contains the JWT token and its type.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Authentication response data")
public class AuthResponseDto {

    /**
     * JWT token
     */
    @Schema(description = "JWT authentication token", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String token;

    /**
     * Token type
     */
    @Schema(description = "Token type", example = "Bearer")
    private String type;
}
