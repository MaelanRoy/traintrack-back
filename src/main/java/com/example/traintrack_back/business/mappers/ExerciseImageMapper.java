package com.example.traintrack_back.business.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.traintrack_back.api.configuration.mappers.GenericMapper;
import com.example.traintrack_back.api.models.ExerciseImageDto;
import com.example.traintrack_back.dao.db.entities.ExerciseImage;

/**
 * Maps ExerciseImage and ExerciseImageDto
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ExerciseImageMapper extends GenericMapper<ExerciseImage, ExerciseImageDto> {
}
