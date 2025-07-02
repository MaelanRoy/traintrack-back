package com.example.traintrack_back.api.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A TrainTrack application user
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "A TrainTrack application user")
public class UserDto {

    /**
     * Internal user identifier
     *
     * @implNote Additional validations :
     * <ul>
     *   <li>Must be absent for creation</li>
     *   <li>Must be present for update</li>
     *   <li>Must match the path ID for updates</li>
     * </ul>
     */
    @Schema(nullable = true, example = "1", description = """
            Internal user identifier<br/>
            Additional validations :
            <ul>
                <li>Must be absent for creation</li>
                <li>Must be present for update</li>
                <li>Must match the path ID for updates</li>
            </ul>
            """)
    @Min(1)
    private Long id;

    /**
     * Unique username for login
     */
    @Schema(example = "maelan_roy", description = "Unique username for login")
    @NotNull
    @Size(min = 3, max = 30)
    private String username;

    /**
     * User's password
     */
    @Schema(example = "password123", description = "User's password")
    @NotNull
    @Size(min = 8, max = 100)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one number and one special character")
    private String password;

    /**
     * User's email address
     */
    @Schema(example = "maelan.roy@example.com", description = "User's email address")
    @NotNull
    @Size(max = 100)
    @Email(message = "Invalid email format")
    private String email;

    /**
     * User's role in the application
     */
    @Schema(example = "NORMAL", description = "User's role (NORMAL, ADMINISTRATOR)", allowableValues = {"NORMAL", "ADMINISTRATOR"})
    @NotNull
    @Pattern(regexp = "NORMAL|ADMINISTRATOR", message = "Role must be NORMAL or ADMINISTRATOR")
    private String role;

  
}
