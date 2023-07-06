package com.devdynasty.CrowdCritic.controller;

import com.devdynasty.CrowdCritic.exception.CategoryNotFoundException;
import com.devdynasty.CrowdCritic.model.Category;
import com.devdynasty.CrowdCritic.repository.CategoryRepository;
import com.devdynasty.CrowdCritic.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService, CategoryRepository categoryRepository) {

        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {

        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) throws CategoryNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findCategoryById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Category> findByName(@PathVariable String name) throws CategoryNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findCategoryByName(name));
    }

    @PostMapping("/import")
    public ResponseEntity<List<Category>> importCategories(@RequestParam("file") MultipartFile file) {

        List<Category> categories = new ArrayList<Category>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            String line;
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");
                String categoryName = data[0].trim();

                Category category = new Category(categoryName);
                categories.add(category);

                categoryService.saveCategory(category);
            }
        } catch (IOException e) {
            // Handle the exception
        }

        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }
}
