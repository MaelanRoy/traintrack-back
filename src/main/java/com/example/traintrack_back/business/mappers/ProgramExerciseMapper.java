package com.example.traintrack_back.business.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.example.traintrack_back.api.configuration.mappers.GenericMapper;
import com.example.traintrack_back.api.models.ProgramExerciseDto;
import com.example.traintrack_back.dao.db.entities.ProgramExercise;

/**
 * Maps ProgramExercise and ProgramExerciseDto
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", 
        uses = {ProgramMapper.class, ExerciseMapper.class})
public interface ProgramExerciseMapper extends GenericMapper<ProgramExercise, ProgramExerciseDto> {

    /**
     * Maps a ProgramExercise entity to a ProgramExerciseDto
     *
     * @param e the entity
     * @return the dto
     */
    @Override
    ProgramExerciseDto toDto(ProgramExercise e);

    /**
     * Maps a ProgramExerciseDto to a ProgramExercise entity
     *
     * @param d the dto
     * @return the entity
     */
    @Override
    @Mapping(target = "program.id", source = "program.id")
    @Mapping(target = "exercise.id", source = "exercise.id")
    ProgramExercise toEntity(ProgramExerciseDto d);
}
