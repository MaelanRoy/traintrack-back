package com.example.traintrack_back.api.models;

import java.util.Set;

import com.example.traintrack_back.api.configuration.validation.annotation.MustBeAbsentForCreation;
import com.example.traintrack_back.api.configuration.validation.annotation.MustBePresentForUpdate;
import com.example.traintrack_back.api.configuration.validation.annotation.MustBeTheSameAsInPath;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A Program
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "program")
public class ProgramDto {
    
     /**
     * Internal identifier for this program table
     *
     * @implNote Additional validations :
     * <ul>
     *   <li>Must be absent for creation requests</li>
     *   <li>Must be present for update / patch requests</li>
     *   <li>Must be the same as in path params for update / patch requests</li>
     * </ul>
     */
    @Schema(nullable = true, example = "1", description = """
            Internal identifier for this program table<br/>
            Additional validations :
            <ul>
                <li>Must be absent for creation requests</li>
                <li>Must be present for update / patch requests</li>
                <li>Must be the same as in path params for update / patch requests</li>
            </ul>
            """)
    @MustBeAbsentForCreation
    @MustBePresentForUpdate
    @MustBeTheSameAsInPath
    @Min(1)
    private Long id;

    /**
     * The name of the program
     */
    @Schema(example = "Full Body Workout", description = "The name of the program")
    @NotNull
    private String name;

    /**
     * The program is created by the user or not
     */
    @Schema(description = "The program is created by the user or not")
    private boolean isDefault;

    /**
     * The user who created the program
     */
    @Schema(description = "The user who created the program")
    private UserDto user;

    /**
     * The category of the program
     */
    @Schema(description = "The category of the program")
    @NotNull
    private CategoryDto category;

    @Schema(description = "Exercises in this program with their configuration")
    private Set<ProgramExerciseDto> exercises;
    
}
