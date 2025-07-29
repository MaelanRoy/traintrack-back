package com.example.traintrack_back.api;

import static com.example.traintrack_back.api.configuration.Constants.Api.EXERCISE;
import static com.example.traintrack_back.api.configuration.Constants.Authority.ADMINISTRATOR;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.traintrack_back.api.models.ExerciseDto;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;



/**
 * Endpoints for a exercise
 */
@Tag(name = "Exercise")
@Validated
@RequestMapping(path = EXERCISE)
public interface ExerciseController {


    /**
     * Returns all existing exercises
     *
     * @return all existing exercises
     */
    @Operation(security = {@SecurityRequirement(name = "bearer-key")}, summary = "Returns all existing things")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<ExerciseDto> findAll();

    /**
     * Returns exercise with a specific id
     *
     * @param id the required id, must be set and greater than 0
     * @return the found thing
     */
    @Operation(security = {@SecurityRequirement(name = "bearer-key")}, summary = "Returns exercise with a specific id")
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    ExerciseDto findById(
            @Parameter(required = true, example = "1", description = "the required id, must be set and greater than 0")
            @Min(1)
            @PathVariable("id") Long id
    );

    /**
     * Creates exercise
     *
     * @param dto a valid exercise to create, must be set
     * @return the created exercise
     */
    @Operation(security = {@SecurityRequirement(name = "bearer-key")}, summary = "Creates exercise")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize(ADMINISTRATOR)
    ExerciseDto create(
            @Parameter(required = true, description = "a valid exercise to create, must be set")
            @Valid
            @RequestBody ExerciseDto dto
    );

    /**
     * Updates exercise with a specific id
     *
     * @param id  the required id, must be set and greater than 0
     * @param dto a valid exercise to update, must be set
     * @return the updated exercise
     */
    @Operation(security = {@SecurityRequirement(name = "bearer-key")}, summary = "Updates exercise with a specific id")
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize(ADMINISTRATOR)
    ExerciseDto updateById(
            @Parameter(description = "Id of the exercise to update")
            @Min(1)
            @PathVariable Long id,
            @Valid
            @RequestBody ExerciseDto dto
    );

    /**
     * Returns random exercises from all categories
     *
     * @param limitPerCategory the number of exercises per category
     * @return list of random exercises from all categories
     */
    @Operation(security = {@SecurityRequirement(name = "bearer-key")}, 
               summary = "Returns random exercises from all categories")
    @GetMapping(path = "/random-by-categories/{limitPerCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<ExerciseDto> findRandomExercisesFromAllCategories(
        @Parameter(required = true, example = "4", description = "Number of exercises per category")
        @Min(1) @Max(20) 
        @PathVariable("limitPerCategory") Integer limitPerCategory
    );

    /**
     * Deletes exercise with a specific id
     *
     * @param id the required id, must be set and greater than 0
     */
    @Operation(security = {@SecurityRequirement(name = "bearer-key")}, summary = "Deletes exercise with a specific id")
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize(ADMINISTRATOR)
    void deleteById(
            @Parameter(description = "Id of the exercise to delete")
            @Min(1)
            @PathVariable Long id
    );


}