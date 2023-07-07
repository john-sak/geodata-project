package com.devdynasty.CrowdCritic.service;

import com.devdynasty.CrowdCritic.exception.CategoryNotFoundException;
import com.devdynasty.CrowdCritic.model.Category;
import com.devdynasty.CrowdCritic.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    public Category findCategoryById(Integer id) throws CategoryNotFoundException {

        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category with id " + id + " not found"));
    }

    public Category findCategoryByName(String name) throws CategoryNotFoundException {

        return categoryRepository
                .findCategoryByName(name)
                .orElseThrow(() -> new CategoryNotFoundException("Category with name " + name + " not found"));
    }

    public List<Category> findAll() {

        return categoryRepository
                .findAll();
    }

    public Category saveCategory(Category category) {

        return categoryRepository
                .findCategoryByName(category.getName())
                .orElseGet(() -> categoryRepository.save(category));
    }
}