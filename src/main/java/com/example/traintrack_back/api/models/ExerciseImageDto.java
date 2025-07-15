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
 * An exercise image
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "exercise image")
public class ExerciseImageDto {

     /**
     * Internal identifier for the image
     *
     * @implNote Additional validations :
     * <ul>
     *   <li>Must be absent for creation requests</li>
     *   <li>Must be present for update / patch requests</li>
     *   <li>Must be the same as in path params for update / patch requests</li>
     * </ul>
     */
    @Schema(nullable = true, example = "1", description = """
            Internal identifier for the image<br/>
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
     * The name of the image
     */
    @Schema(example = "exercise_image.jpg", description = "The name of the image")
    private String name;

    /**
     * The image
     */
    @Schema(description = "The image")
    @NotNull
    private byte[] imageData;

    /**
     * The image type
     */
    @Schema(description = "The image type")
    @NotNull
    private String imageType;

    /**
     * The exercise this image is associated with
     */
    @Schema(description = "The exercise this image is associated with")
    @NotNull
    private ExerciseDto exercise;
}
