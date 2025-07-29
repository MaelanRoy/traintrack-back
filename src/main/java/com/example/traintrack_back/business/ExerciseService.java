package com.example.traintrack_back.business;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.example.traintrack_back.api.models.ExerciseDto;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

/**
 * Controls for exercise
 */
@Transactional
@Validated
public interface ExerciseService {

    /**
     * Returns all existing exercises
     *
     * @return all existing exercises
     */

    List<ExerciseDto> findAll();

    /**
     * Returns exercise with a specific id
     *
     * @param id the required id, must be set
     * @return the found exercise
     * @throws EntityNotFoundException if exercise couldn't be found
     */
    ExerciseDto findById(@NotNull Long id);

    /**
     * Creates exercise
     *
     * @param dto a valid exercise to create, must be set
     * @return the created exercise
     */
    ExerciseDto create(@Valid @NotNull ExerciseDto dto);

    /**
     * Updates exercise with a specific id
     *
     * @param id  the required id, must be set
     * @param dto a valid exercise to create, must be set
     * @return the updated exercise
     * @throws EntityNotFoundException if exercise couldn't be found
     */
    ExerciseDto updateById(@NotNull Long id, @Valid @NotNull ExerciseDto dto);

    /**
     * Deletes a exercise with a specific id
     *
     * @param id the required id, must be set
     * @throws EntityNotFoundException if exercise couldn't be found
     */
    void deleteById(@NotNull Long id);

    /**
     * Returns random exercises from all categories
     *
     * @param limitPerCategory number of exercises per category
     * @return list of random exercises from all categories
     */
    List<ExerciseDto> findRandomExercisesFromAllCategories(@NotNull @Min(1) Integer limitPerCategory);
}
