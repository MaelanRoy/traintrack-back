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
 * A User measurement
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "user measurement")
public class UserMeasurementDto {
    
      /**
     * Internal identifier for this user measurement table
     *
     * @implNote Additional validations :
     * <ul>
     *   <li>Must be absent for creation requests</li>
     *   <li>Must be present for update / patch requests</li>
     *   <li>Must be the same as in path params for update / patch requests</li>
     * </ul>
     */
    @Schema(nullable = true, example = "1", description = """
            Internal identifier for this user measurement table<br/>
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
     * The Date of the measurement
     */
    @Schema(example = "2025-04-07", description = "The Date of the measurement")
    @NotNull
    private ZonedDateTime date;

    /**
     * The weight of the user in kg
     */
    @Schema(example = "70.5", description = "The weight of the user in kg")
    @NotNull
    private Float weight;

    /**
     * The height of the user in cm
     */
    @Schema(example = "180", description = "The height of the user in cm")
    @NotNull
    private Float height;

    /**
     * The user who made the measurement
     */
    @Schema(description = "The user who made the measurement")
    @NotNull
    private UserDto user;
}
