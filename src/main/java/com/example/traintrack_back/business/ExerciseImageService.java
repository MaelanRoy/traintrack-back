package com.example.traintrack_back.business;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.example.traintrack_back.api.models.ExerciseImageDto;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;

/**
 * Controls for exercise image
 */
@Transactional
@Validated
public interface ExerciseImageService {

    /**
     * Returns images with a specific exercise id
     *
     * @param exerciseId the required exercise id, must be set and greater than 0
     * @return the found image
     */
    List<ExerciseImageDto> findByExerciseId(@NotNull Long exerciseId);

    /**
     * Creates a new Image
     *
     * @param dto ExerciseImageDto to create
     * @return a new ExerciseImageDto
     */
    ExerciseImageDto create(@NotNull ExerciseImageDto dto);

    /**
     * Updates an image with a specific id
     *
     * @param id  the required id, must be set
     * @param dto a valid image to create, must be set
     * @return the updated image
     * @throws EntityNotFoundException if image couldn't be found
     */
    ExerciseImageDto updateById(@NotNull Long id, @NotNull ExerciseImageDto dto);

    /**
     * Deletes an image with a specific id
     *
     * @param id the required id, must be set
     * @throws EntityNotFoundException if image couldn't be found
     */
    void deleteById(@NotNull Long id);
}
