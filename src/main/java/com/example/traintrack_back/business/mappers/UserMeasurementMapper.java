package com.example.traintrack_back.business.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.traintrack_back.api.configuration.mappers.GenericMapper;
import com.example.traintrack_back.api.models.UserMeasurementDto;
import com.example.traintrack_back.dao.db.entities.UserMeasurement;

/**
 * Maps UserMeasurement and UserMeasurementDto
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMeasurementMapper extends GenericMapper<UserMeasurement, UserMeasurementDto> {
}
