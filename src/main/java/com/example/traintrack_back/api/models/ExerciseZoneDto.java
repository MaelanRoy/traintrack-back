package com.example.traintrack_back.api.models;

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
 * An Exercise Zone
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "exercise zone")
public class ExerciseZoneDto {
    
     /**
     * Internal identifier for this exercise zone table
     *
     * @implNote Additional validations :
     * <ul>
     *   <li>Must be absent for creation requests</li>
     *   <li>Must be present for update / patch requests</li>
     *   <li>Must be the same as in path params for update / patch requests</li>
     * </ul>
     */
    @Schema(nullable = true, example = "1", description = """
            Internal identifier for this exercise zone table<br/>
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
     * The name of the exercise zone
     */
    @Schema(example = "biceps", description = "The name of the exercise zone")
    @NotNull
    @Size(min = 1, max = 50)
    private String name;
}
