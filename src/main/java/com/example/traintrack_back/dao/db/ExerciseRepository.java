package com.example.traintrack_back.dao.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.traintrack_back.dao.db.entities.Exercise;

/**
 * DB Access for exercises
 */
@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long>, JpaSpecificationExecutor<Exercise> {
    
    /**
     * Find random exercises by category
     */
    @Query(value = """
        SELECT * FROM exercise 
        WHERE category_id = :categoryId 
        ORDER BY RANDOM() 
        LIMIT :limit
        """, nativeQuery = true)
    List<Exercise> findRandomByCategory(@Param("categoryId") Long categoryId, @Param("limit") Integer limit);
}
