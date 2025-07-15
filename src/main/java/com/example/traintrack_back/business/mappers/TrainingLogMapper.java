package com.example.traintrack_back.business.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.traintrack_back.api.configuration.mappers.GenericMapper;
import com.example.traintrack_back.api.models.TrainingLogDto;
import com.example.traintrack_back.dao.db.entities.TrainingLog;

/**
 * Maps TrainingLog and TrainingLogDto
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", 
        uses = {UserMapper.class, ExerciseMapper.class, ProgramMapper.class})
public interface TrainingLogMapper extends GenericMapper<TrainingLog, TrainingLogDto> {
}
