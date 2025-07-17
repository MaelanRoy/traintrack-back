package com.example.traintrack_back.business;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.example.traintrack_back.api.models.ExerciseZoneDto;

import jakarta.transaction.Transactional;

/**
 * Controls for exerciseZone
 */
@Transactional
@Validated
public interface ExerciseZoneService {
    
    /**
     * Returns all existing exercise zones
     *
     * @return all existing exercise zones
     */

    List<ExerciseZoneDto> findAll();
}
