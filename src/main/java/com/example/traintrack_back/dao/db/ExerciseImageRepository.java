package com.example.traintrack_back.dao.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.traintrack_back.dao.db.entities.ExerciseImage;

/**
 * DB Access for exercise images
 */
@Repository
public interface ExerciseImageRepository extends JpaRepository<ExerciseImage, Long>, JpaSpecificationExecutor<ExerciseImage> {

    /**
     * Find all images for a given exercise id.
     *
     * @param exerciseId the exercise id
     * @return the image
     */
    List<ExerciseImage> findByExerciseId(Long exerciseId);
}
