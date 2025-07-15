package com.example.traintrack_back.api.models;

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
 * A link between a program and an exercise
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "link between a program and an exercise")
public class ProgramExerciseDto {
    
     /**
     * Internal identifier for this program exercise table
     *
     * @implNote Additional validations :
     * <ul>
     *   <li>Must be absent for creation requests</li>
     *   <li>Must be present for update / patch requests</li>
     *   <li>Must be the same as in path params for update / patch requests</li>
     * </ul>
     */
    @Schema(nullable = true, example = "1", description = """
            Internal identifier for this program exercise table<br/>
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
     * The program
     */
    @Schema(description = "The program")
    @NotNull
    private ProgramDto program;

    /**
     * The exercise
     */
    @Schema(description = "The exercise")
    @NotNull
    private ExerciseDto exercise;

    /**
     * The position of the exercise in the program
     */
    @Schema( example = "1", description = "The position of the exercise in the program")
    @NotNull
    @Min(1)
    private Integer position;

    /**
     * The number of sets for this exercise
     */
    @Schema(example = "3", description = "Number of sets")
    private Integer sets;

    /**
     * The number of repetitions for this exercise
     */
    @Schema(example = "10", description = "Number of repetitions per set")
    private Integer reps;

    /**
     * The weight for this exercise
     */
    @Schema(example = "120", description = "Duration in seconds")
    private Integer duration;
}
