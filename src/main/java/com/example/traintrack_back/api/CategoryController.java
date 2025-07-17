package com.example.traintrack_back.api;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.example.traintrack_back.api.models.CategoryDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import static com.example.traintrack_back.api.configuration.Constants.Api.CATEGORY;

import java.util.List;

/**
 * Endpoints for a category
 */
@Tag(name = "Category")
@Validated
@RequestMapping(path = CATEGORY)
public interface CategoryController {

    /**
     * Returns all existing categories
     *
     * @return all existing categories
     */
    @Operation(security = {@SecurityRequirement(name = "bearer-key")}, summary = "Returns all existing categories")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<CategoryDto> findAll();
}
