package com.example.traintrack_back.api;

import static com.example.traintrack_back.api.configuration.Constants.Api.EXERCISE_IMAGE;
import static com.example.traintrack_back.api.configuration.Constants.Authority.ADMINISTRATOR;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.example.traintrack_back.api.models.ExerciseImageDto;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.HttpStatus;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


/**
 * Endpoints for an exercise image
 */
@Tag(name = "ExerciseImage")
@Validated
@RequestMapping(path = EXERCISE_IMAGE)
public interface ExerciseImageController {


    /**
     * Returns exercise images with a specific exercise id
     *
     * @param exerciseId the required exercise id, must be set and greater than 0
     * @return the list of exercise images
     */
    @Operation(security = {@SecurityRequirement(name = "bearer-key")}, summary = "Returns list of exercise images with a specific exerciseId")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<ExerciseImageDto> findByExerciseId(
            @Parameter(required = true, example = "1", description = "the required exerciseId, must be set and greater than 0")
            @Min(1)
            @RequestParam("exercise-id") Long exerciseId
    );

    /**
     * Creates exercise image
     *
     * @param exerciseImage a valid exercise image to create, must be set
     * @param exerciseId the exercise id linked to the image
     * @return the created exercise image
     */
    @Operation(security = {@SecurityRequirement(name = "bearer-key")}, summary = "Creates exercise image")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize(ADMINISTRATOR)
    ExerciseImageDto create(
        @Parameter(required = true, description = "a valid exercise image to create, must be set")
        @Valid
        @RequestPart("exerciceImage") MultipartFile exerciseImage,
        @Parameter(required = true, description = "the exercise linked to the image")
        Long exerciseId, 
        @Parameter(required = true, description = "the position of the image")
        @Min(1)
        Integer position
    );


    /**
     * Updates exercise image with a specific id
     *
     * @param id the id of the image to update
     * @param exerciseImage the data used for the update
     * @param exerciseId the id of the exercise to which the image is associated
     * @return the updated ExerciseImageDto
     */
    @Operation(security = {@SecurityRequirement(name = "bearer-key")}, summary = "Updates image with a specific id")
    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize(ADMINISTRATOR)
    ExerciseImageDto updateById(
        @Parameter(required = true, example = "1", description = "the required id, must be set and greater than 0")
        @Min(1)
        @PathVariable("id") Long id,
        @Parameter(required = true, description = "a valid image to update, must be set")
        @RequestPart("exerciseImage") MultipartFile exerciseImage,
        @Parameter(required = true, description = "the exercise linked to the image")
        @Min(1)
        Long exerciseId,
        @Parameter(required = true, description = "the position of the image")
        @Min(1)
        Integer position

    );


    /**
     * Deletes exercise image with a specific id
     *
     * @param id the required id, must be set and greater than 0
     */
    @Operation(security = {@SecurityRequirement(name = "bearer-key")}, summary = "Deletes exercise image with a specific id")
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize(ADMINISTRATOR)
    void deleteById(
            @Parameter(required = true, example = "1", description = "the required id, must be set and greater than 0")
            @Min(1)
            @PathVariable Long id
    );


}