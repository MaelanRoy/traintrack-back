package com.example.traintrack_back.business.impl;

import org.springframework.stereotype.Service;

import com.example.traintrack_back.api.models.CategoryDto;
import com.example.traintrack_back.business.CategoryService;
import com.example.traintrack_back.business.mappers.CategoryMapper;
import com.example.traintrack_back.dao.db.CategoryRepository;

import java.util.List;

/**
 * implementation of {@link CategoryService}
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    /**
     * DB Access for category
     */
    private final CategoryRepository categoryRepository;

    /**
     * Category / CategoryDto mapping
     */
    private final CategoryMapper categoryMapper;

    /**
     * Injection constructor
     *
     * @param repository DB Access for category
     * @param mapper     Category / CategoryDto mapping
     */
    CategoryServiceImpl(CategoryRepository repository, CategoryMapper mapper) {
        this.categoryRepository = repository;
        this.categoryMapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CategoryDto> findAll() {
        return categoryMapper.toDtos(categoryRepository.findAll());
    }
}
