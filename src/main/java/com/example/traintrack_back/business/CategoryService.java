package com.example.traintrack_back.business;

import jakarta.transaction.Transactional;
import org.springframework.validation.annotation.Validated;

import com.example.traintrack_back.api.models.CategoryDto;

import java.util.List;

/**
 * Controls for category
 */
@Transactional
@Validated
public interface CategoryService {

    /**
     * Returns all existing categories
     *
     * @return all existing categories
     */

    List<CategoryDto> findAll();
}
