package com.example.traintrack_back.api;

import static com.example.traintrack_back.api.configuration.Constants.Api.EXERCISE_ZONE;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.traintrack_back.api.models.ExerciseZoneDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Endpoints for a exerciseZone
 */
@Tag(name = "ExerciseZone")
@Validated
@RequestMapping(path = EXERCISE_ZONE)
public interface ExerciseZoneController {
    
     /**
     * Returns all existing exercise zones
     *
     * @return all existing exercise zones
     */
    @Operation(security = {@SecurityRequirement(name = "bearer-key")}, summary = "Returns all existing exercise zones")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ExerciseZoneDto> findAll();
}
