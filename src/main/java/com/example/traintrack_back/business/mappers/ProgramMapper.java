package com.example.traintrack_back.business.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.traintrack_back.api.configuration.mappers.GenericMapper;
import com.example.traintrack_back.api.models.ProgramDto;
import com.example.traintrack_back.dao.db.entities.Program;

/**
 * Maps Program and ProgramDto
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", 
        uses = {UserMapper.class, CategoryMapper.class})
public interface ProgramMapper extends GenericMapper<Program, ProgramDto> {
}
