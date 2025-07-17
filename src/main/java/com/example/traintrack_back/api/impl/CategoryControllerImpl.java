package com.example.traintrack_back.api.impl;


import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RestController;

import com.example.traintrack_back.api.AbstractRestController;
import com.example.traintrack_back.api.CategoryController;
import com.example.traintrack_back.api.models.CategoryDto;
import com.example.traintrack_back.business.CategoryService;
import static com.example.traintrack_back.api.configuration.Constants.Api.CATEGORY;

import java.util.List;


/**
 * implementation of {@link CategoryController}
 */
@Slf4j
@RestController
public class CategoryControllerImpl extends AbstractRestController implements CategoryController {
    /**
     * Controls for category
     */
    private final CategoryService categoryService;

    /**
     * Injection constructor
     *
     * @param categoryService Controls for category
     */
    public CategoryControllerImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CategoryDto> findAll() {
        log.info("Rest : GET - {}", CATEGORY);
        return logResponse(log, "GET", categoryService.findAll());
    }
}
