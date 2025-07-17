package com.example.traintrack_back.dao.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.traintrack_back.dao.db.entities.ExerciseZone;

/**
 * DB Access for exercise zones.
 */
@Repository
public interface ExerciseZoneRepository extends JpaRepository<ExerciseZone, Long>, JpaSpecificationExecutor<ExerciseZone> {
}
