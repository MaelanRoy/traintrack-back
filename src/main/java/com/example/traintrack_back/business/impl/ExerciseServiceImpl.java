package com.example.traintrack_back.business.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.traintrack_back.api.exceptions.EntityNotFoundException;
import com.example.traintrack_back.api.models.ExerciseDto;
import com.example.traintrack_back.business.ExerciseService;
import com.example.traintrack_back.business.mappers.ExerciseMapper;
import com.example.traintrack_back.dao.db.CategoryRepository;
import com.example.traintrack_back.dao.db.ExerciseRepository;
import com.example.traintrack_back.dao.db.entities.Category;
import com.example.traintrack_back.dao.db.entities.Exercise;

/**
 * implementation of {@link ExerciseService}
 */
@Service
public class ExerciseServiceImpl implements ExerciseService {

    /**
     * DB Access for exercise
     */
    private final ExerciseRepository exerciseRepository;
    
    /**
     * DB Access for category
     */
    private final CategoryRepository categoryRepository;

    /**
     * Exercise / ExerciseDto mapping
     */
    private final ExerciseMapper exerciseMapper;

    /**
     * Injection constructor
     *
     * @param exerciseRepository DB Access for exercise
     * @param categoryRepository DB Access for category
     * @param mapper             Exercise / ExerciseDto mapping
     */
    ExerciseServiceImpl(ExerciseRepository exerciseRepository, CategoryRepository categoryRepository, ExerciseMapper mapper) {
        this.exerciseRepository = exerciseRepository;
        this.categoryRepository = categoryRepository;
        this.exerciseMapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ExerciseDto> findAll() {
        List<Exercise> all = exerciseRepository.findAll();
        return exerciseMapper.toDtos(all);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExerciseDto findById(Long id) {
        return exerciseRepository
                .findById(id)
                .map(exerciseMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(Exercise.class.getSimpleName(), id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExerciseDto create(ExerciseDto dto) {
        Exercise entity = exerciseMapper.toEntity(dto);
        Exercise created = exerciseRepository.save(entity);
        return exerciseMapper.toDto(created);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExerciseDto updateById(Long id, ExerciseDto dto) {
        if (exerciseRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException(Exercise.class.getSimpleName(), id);
        }

        Exercise entity = exerciseMapper.toEntity(dto);
        Exercise updated = exerciseRepository.save(entity);
        return exerciseMapper.toDto(updated);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        if (exerciseRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException(Exercise.class.getSimpleName(), id);
        }

        exerciseRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ExerciseDto> findRandomExercisesFromAllCategories(Integer limitPerCategory) {
        // Récupérer toutes les catégories
        List<Category> categories = categoryRepository.findAll();
        
        // Mélanger l'ordre des catégories pour avoir un ordre aléatoire
        Collections.shuffle(categories);
        
        // Pour chaque catégorie, récupérer des exercices aléatoires
        List<ExerciseDto> allExercises = new ArrayList<>();
        
        for (Category category : categories) {
            List<Exercise> randomExercises = exerciseRepository
                .findRandomByCategory(category.getId(), limitPerCategory);
            
            List<ExerciseDto> exerciseDtos = exerciseMapper.toDtos(randomExercises);
            allExercises.addAll(exerciseDtos);
        }
        
        return allExercises;
    }

}