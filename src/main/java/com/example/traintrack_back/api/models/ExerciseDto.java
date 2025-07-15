package com.example.traintrack_back.api.models;

import java.util.Set;

import com.example.traintrack_back.api.configuration.validation.annotation.MustBeAbsentForCreation;
import com.example.traintrack_back.api.configuration.validation.annotation.MustBePresentForUpdate;
import com.example.traintrack_back.api.configuration.validation.annotation.MustBeTheSameAsInPath;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An Exercise
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "exercise")
public class ExerciseDto {
    
     /**
     * Internal identifier for this exercise table
     *
     * @implNote Additional validations :
     * <ul>
     *   <li>Must be absent for creation requests</li>
     *   <li>Must be present for update / patch requests</li>
     *   <li>Must be the same as in path params for update / patch requests</li>
     * </ul>
     */
    @Schema(nullable = true, example = "1", description = """
            Internal identifier for this exercise table<br/>
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
     * The name of the exercise
     */
    @Schema(example = "curl", description = "The name of the exercise")
    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    /**
     * The description of the exercise
     */
    @Schema(example = "Bicep curl with dumbbells", description = "The description of the exercise")
    @Size(min = 1, max = 255)
    private String description;

    /**
     * The category of the exercise
     */
    @Schema(description = "The category of the exercise")
    @NotNull
    private CategoryDto category;

    /**
     * The calories burned per minute for this exercise
     */
    @Schema(example = "10", description = "The calories burned per minute for this exercise")
    @Min(1)
    private Float caloriesPerMinute;

    /**
     * The calories burned per repetition for this exercise
     */
    @Schema(example = "0.5", description = "The calories burned per repetition for this exercise")
    @Min(1)
    private Float caloriesPerRepetition;

    /**
     * The default duration of the exercise in seconds
     */
    @Schema(example = "60", description = "The default duration of the exercise in seconds")
    @Min(1)
    private Integer defaultDuration;

    /**
     * The default number of repetitions for the exercise
     */
    @Schema(example = "10", description = "The default number of repetitions for the exercise")
    @Min(1)
    private Integer defaultRepetitions;

    /**
     * The default number of sets for the exercise
     */
    @Schema(example = "3", description = "The default number of sets for the exercise")
    @Min(1)
    private Integer defaultSets;

    /**
     * The default equipment weight for the exercise in kilograms
     */
    @Schema(example = "5", description = "The default equipment weight for the exercise in kilograms")
    @Min(0)
    private Integer defaultEquipmentWeight;

    /**
     * The list of zones this exercise targets
     */
    @Schema(description = "The zones this exercise targets")
    private Set<ExerciseZoneDto> zones;
}
