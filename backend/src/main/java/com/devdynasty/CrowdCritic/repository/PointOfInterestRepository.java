package com.devdynasty.CrowdCritic.repository;

import com.devdynasty.CrowdCritic.model.PointOfInterest;
import com.devdynasty.CrowdCritic.model.SearchRequestBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest,Integer> {


    @Override
    Optional<PointOfInterest> findById(Integer id);


    List<PointOfInterest> findAll();


    Optional<PointOfInterest> findPointsOfInterestByName(String name);


    @Query("")
    List<PointOfInterest> findByFreeText(String text);

    @Query("")
    List<PointOfInterest> findByDistance(SearchRequestBody.Filters.Distance distance);

    @Query("")
    List<PointOfInterest> findByKeywords(List<String> keywords);

    @Query("")
    List<PointOfInterest> findByCategories(List<String> categories);
}
