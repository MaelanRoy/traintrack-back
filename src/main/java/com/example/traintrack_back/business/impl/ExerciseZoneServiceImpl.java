package com.example.traintrack_back.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.traintrack_back.api.models.ExerciseZoneDto;
import com.example.traintrack_back.business.ExerciseZoneService;
import com.example.traintrack_back.business.mappers.ExerciseZoneMapper;
import com.example.traintrack_back.dao.db.ExerciseZoneRepository;

/**
 * implementation of {@link ExerciseZoneService}
 */
@Service
public class ExerciseZoneServiceImpl implements ExerciseZoneService {
    
     /**
     * DB Access for ExerciseZone
     */
    private final ExerciseZoneRepository exerciseZoneRepository;

    /**
     * ExerciseZone / ExerciseZoneDto mapping
     */
    private final ExerciseZoneMapper exerciseZoneMapper;

    /**
     * Injection constructor
     *
     * @param repository DB Access for exerciseZone
     * @param mapper     ExerciseZone / ExerciseZoneDto mapping
     */
    ExerciseZoneServiceImpl(ExerciseZoneRepository repository, ExerciseZoneMapper mapper) {
        this.exerciseZoneRepository = repository;
        this.exerciseZoneMapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ExerciseZoneDto> findAll() {
        return exerciseZoneMapper.toDtos(exerciseZoneRepository.findAll());
    }
}
