package com.example.traintrack_back.business.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.traintrack_back.api.configuration.mappers.GenericMapper;
import com.example.traintrack_back.api.models.CategoryDto;
import com.example.traintrack_back.dao.db.entities.Category;
/**
 * Maps Category and CategoryDto
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CategoryMapper extends GenericMapper<Category, CategoryDto> {
}