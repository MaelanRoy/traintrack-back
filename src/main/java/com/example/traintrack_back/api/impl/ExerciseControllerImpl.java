package com.example.traintrack_back.api.impl;

import static com.example.traintrack_back.api.configuration.Constants.Api.EXERCISE;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.traintrack_back.api.AbstractRestController;
import com.example.traintrack_back.api.ExerciseController;
import com.example.traintrack_back.api.models.ExerciseDto;
import com.example.traintrack_back.business.ExerciseService;

import lombok.extern.slf4j.Slf4j;

/**
 * implementation of {@link ExerciseController}
 */
@Slf4j
@RestController
public class ExerciseControllerImpl extends AbstractRestController implements ExerciseController {

    /**
     * Controls for exercise
     */
    private final ExerciseService exerciseService;


    /**
     * Injection constructor
     *
     * @param exerciseService Controls for exercise
     */
    public ExerciseControllerImpl(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<ExerciseDto> findAll() {
        log.info("Rest : GET - {}", EXERCISE);
        return logResponse(log, "GET", exerciseService.findAll());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExerciseDto findById(Long id) {
        log.info("Rest : GET - {}/{}", EXERCISE, id);
        return logResponse(log, "GET", exerciseService.findById(id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExerciseDto create(ExerciseDto dto) {
                log.info("Creating exercise: {}", dto);

        log.info("Rest : POST - {}", EXERCISE);
        logRequest(log, dto);
        return logResponse(log, "POST", exerciseService.create(dto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExerciseDto updateById(Long id, ExerciseDto dto) {
        log.info("Rest : PUT - {}/{}", EXERCISE, id);
        logRequest(log, dto);
        return logResponse(log, "PUT", exerciseService.updateById(id, dto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        log.info("Rest : DELETE - {}/{}", EXERCISE, id);
        exerciseService.deleteById(id);
        logResponse(log, "DELETE");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ExerciseDto> findRandomExercisesFromAllCategories(Integer limitPerCategory) {
        log.info("Rest : GET - {}/random-by-categories?limitPerCategory={}", EXERCISE, limitPerCategory);
        return logResponse(log, "GET", exerciseService.findRandomExercisesFromAllCategories(limitPerCategory));
    }


}