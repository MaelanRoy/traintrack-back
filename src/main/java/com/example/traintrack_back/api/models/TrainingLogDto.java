package com.example.traintrack_back.api.models;

import java.time.ZonedDateTime;

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
 * A Training Log
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "training log")
public class TrainingLogDto {
    
     /**
     * Internal identifier for this training log table
     *
     * @implNote Additional validations :
     * <ul>
     *   <li>Must be absent for creation requests</li>
     *   <li>Must be present for update / patch requests</li>
     *   <li>Must be the same as in path params for update / patch requests</li>
     * </ul>
     */
    @Schema(nullable = true, example = "1", description = """
            Internal identifier for this training log table<br/>
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
     * The user associated with this training log
     */
    @Schema(description = "The user associated with this training log")
    @NotNull
    private UserDto user;

    /**
     * the exercise associated with this training log
     */
    @Schema(description = "the exercise associated with this training log")
    private ExerciseDto exercise;

    /**
     * The program associated with this training log
     */
    @Schema(description = "The program associated with this training log")
    private ProgramDto program;

    /**
     * The date of the training log
     */
    @Schema(example = "2025-04-07", description = "The date of the training log")
    @NotNull
    private ZonedDateTime date;

    /**
     * The sets of the exercise performed during the training
     */
    @Schema(description = "The sets of the exercise performed during the training")
    private Integer sets;

    /**
     * The repetitions of the exercise performed during the training
     */
    @Schema(description = "The repetitions of the exercise performed during the training")
    private Integer repetitions;

    /**
     * The duration of the exercise performed during the training in seconds
     */
    @Schema(example = "120", description = "The duration of the exercise performed during the training in seconds")
    private Integer duration;

    /**
     * The equipment weight used for the exercise performed during the training in kg
     */
    @Schema(example = "120", description = "The weight used for the exercise performed during the training in kg")
    private Integer equipmentWeight;

    /**
     * The calories burned during the training log
     */
    @Schema(example = "500", description = "The calories burned during the training log")
    private Float caloriesBurned;
    
    
}
