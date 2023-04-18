package com.devdynasty.CrowdCritic.repository;

import com.devdynasty.CrowdCritic.model.AppBuilding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppBuildingRepository extends JpaRepository<AppBuilding,Integer> {


    @Override
    Optional<AppBuilding> findById(Integer id);


    List<AppBuilding> findAll();


    Optional<AppBuilding> findAppBuildingsByName(String name);


}
