package com.example.traintrack_back.api.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A registration request
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Registration request data")
public class RegisterRequestDto {

    /**
     * User's username
     */
    @Schema(example = "maelan_roy", description = "User's username")
    @NotNull
    @Size(min = 3, max = 30)
    private String username;

    /**
     * The user's email
     */
    @Schema(example = "maelan.roy@example.com", description = "User's email address")
    @NotNull
    @Size(max = 100)
    @Email(message = "Invalid email format")
    private String email;

    /**
     * User's password
     */
    @Schema(description = "User's password", example = "password123")
    @NotNull
    @Size(min = 8, max = 100)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one number and one special character")
    private String password;
}
