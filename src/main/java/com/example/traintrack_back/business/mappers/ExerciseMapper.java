package com.example.traintrack_back.business.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.traintrack_back.api.configuration.mappers.GenericMapper;
import com.example.traintrack_back.api.models.ExerciseDto;
import com.example.traintrack_back.dao.db.entities.Exercise;

/**
 * Maps Exercise and ExerciseDto
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ExerciseMapper extends GenericMapper<Exercise, ExerciseDto> {
}
