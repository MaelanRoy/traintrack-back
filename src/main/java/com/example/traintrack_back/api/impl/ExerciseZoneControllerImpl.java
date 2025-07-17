package com.example.traintrack_back.api.impl;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.traintrack_back.api.AbstractRestController;
import com.example.traintrack_back.api.ExerciseZoneController;
import com.example.traintrack_back.api.models.ExerciseZoneDto;
import com.example.traintrack_back.business.ExerciseZoneService;
import static com.example.traintrack_back.api.configuration.Constants.Api.EXERCISE_ZONE;

import lombok.extern.slf4j.Slf4j;

/**
 * implementation of {@link ExerciseZoneController}
 */
@Slf4j
@RestController
public class ExerciseZoneControllerImpl extends AbstractRestController implements ExerciseZoneController {

    /**
     * Controls for exerciseZone
     */
    private final ExerciseZoneService exerciseZoneService;

    /**
     * Injection constructor
     *
     * @param exerciseZoneService Controls for exerciseZone
     */
    public ExerciseZoneControllerImpl(ExerciseZoneService exerciseZoneService) {
        this.exerciseZoneService = exerciseZoneService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ExerciseZoneDto> findAll() {
        log.info("Rest : GET - {}", EXERCISE_ZONE);
        return logResponse(log, "GET", exerciseZoneService.findAll());
    }
    
}
