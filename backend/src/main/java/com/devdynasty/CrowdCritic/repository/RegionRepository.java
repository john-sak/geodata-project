package com.devdynasty.CrowdCritic.repository;

import com.devdynasty.CrowdCritic.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region,Integer> {


    public Optional<Region> findRegionsByName(String name);



}
