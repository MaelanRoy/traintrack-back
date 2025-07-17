package com.example.traintrack_back.business.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.example.traintrack_back.api.configuration.mappers.GenericMapper;
import com.example.traintrack_back.api.models.ExerciseImageDto;
import com.example.traintrack_back.dao.db.entities.ExerciseImage;

/**
 * Maps ExerciseImage and ExerciseImageDto
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ExerciseImageMapper extends GenericMapper<ExerciseImage, ExerciseImageDto> {

    /**
     * Maps an ExerciseImage entity to an ExerciseImageDto
     *
     * @param e the entity
     * @return the dto
     */
    @Override
    @Mapping(target = "exerciseId", source = "exercise.id")
    ExerciseImageDto toDto(ExerciseImage e);

    /**
     * Maps an ExerciseImageDto to an ExerciseImage entity
     *
     * @param d the dto
     * @return the entity
     */
    @Override
    @Mapping(target = "exercise.id", source = "exerciseId")
    ExerciseImage toEntity(ExerciseImageDto d);
}
