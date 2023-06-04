package com.devdynasty.CrowdCritic.repository;

import com.devdynasty.CrowdCritic.model.PointOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest,Integer> {


    @Override
    Optional<PointOfInterest> findById(Integer id);


    List<PointOfInterest> findAll();


    Optional<PointOfInterest> findPointsOfInterestByName(String name);


}
