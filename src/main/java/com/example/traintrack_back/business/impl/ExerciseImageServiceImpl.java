package com.example.traintrack_back.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.traintrack_back.api.exceptions.EntityNotFoundException;
import com.example.traintrack_back.api.models.ExerciseImageDto;
import com.example.traintrack_back.business.ExerciseImageService;
import com.example.traintrack_back.business.mappers.ExerciseImageMapper;
import com.example.traintrack_back.dao.db.ExerciseImageRepository;
import com.example.traintrack_back.dao.db.entities.Exercise;
import com.example.traintrack_back.dao.db.entities.ExerciseImage;

/**
 * implementation of {@link ExerciseImageService}
 */
@Service
public class ExerciseImageServiceImpl implements ExerciseImageService {


    /**
     * DB Access for ExerciseImage
     */
    private final ExerciseImageRepository exerciseImageRepository;

    /**
     * ExerciseImage / ExerciseImageDto mapping
     */
    private final ExerciseImageMapper exerciseImageMapper;

    /**
     * Injection constructor
     *
     * @param repository DB Access for exercise image
     * @param mapper     ExerciseImage / ExerciseImageDto mapping
     */
    ExerciseImageServiceImpl(ExerciseImageRepository repository, ExerciseImageMapper mapper) {
        this.exerciseImageRepository = repository;
        this.exerciseImageMapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    public List<ExerciseImageDto> findByBoardGameId(Long exerciseId) {
        List<ExerciseImage> images = exerciseImageRepository.findByExerciseId(exerciseId);
        return exerciseImageMapper.toDtos(images);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public ExerciseImageDto create(ExerciseImageDto dto) {
        ExerciseImage entity = exerciseImageMapper.toEntity(dto);
        ExerciseImage created = exerciseImageRepository.save(entity);
        return exerciseImageMapper.toDto(created);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExerciseImageDto updateById(Long id, ExerciseImageDto dto) {
        if (exerciseImageRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException(Exercise.class.getSimpleName(), id);
        }
        ExerciseImage entity = exerciseImageMapper.toEntity(dto);
        ExerciseImage updated = exerciseImageRepository.save(entity);
        return exerciseImageMapper.toDto(updated);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        if (exerciseImageRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException(ExerciseImage.class.getSimpleName(), id);
        }
        exerciseImageRepository.deleteById(id);
    }

}
