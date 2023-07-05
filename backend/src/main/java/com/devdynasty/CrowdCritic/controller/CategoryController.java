package com.devdynasty.CrowdCritic.controller;

import com.devdynasty.CrowdCritic.model.Category;
import com.devdynasty.CrowdCritic.repository.CategoryRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/import")
    public void importCategories(@RequestParam("file") MultipartFile file) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            String line;
            List<Category> categories = new ArrayList<Category>();

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");
                String categoryName = data[0].trim();

                Category category = new Category();
//                category.setId(999);  ERROR: ID needs to be automatically assigned for each new category
                category.setName(categoryName);
                categories.add(category);
            }

            categoryRepository.saveAll(categories);
        } catch (IOException e) {
            // Handle the exception
        }
    }
}
