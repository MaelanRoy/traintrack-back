package com.example.traintrack_back.business.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.traintrack_back.api.configuration.mappers.GenericMapper;
import com.example.traintrack_back.api.models.ExerciseZoneDto;
import com.example.traintrack_back.dao.db.entities.ExerciseZone;

/**
 * Maps ExerciseZone and ExerciseZoneDto
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ExerciseZoneMapper extends GenericMapper<ExerciseZone, ExerciseZoneDto> {
}
