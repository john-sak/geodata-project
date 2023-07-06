package com.devdynasty.CrowdCritic.repository;

import com.devdynasty.CrowdCritic.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Override
    Optional<Category> findById(Integer integer);

    Optional<Category> findCategoryByName(String name);
}
