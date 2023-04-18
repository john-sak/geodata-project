package com.devdynasty.CrowdCritic.service;

import com.devdynasty.CrowdCritic.model.AppBuilding;
import com.devdynasty.CrowdCritic.repository.AppBuildingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppBuildingService {

    AppBuildingRepository appBuildingRepository;



    public AppBuildingService(AppBuildingRepository appBuildingRepository) { this.appBuildingRepository = appBuildingRepository; }


    public AppBuilding getAppBuildingById(Integer id) {

        return this.appBuildingRepository.findById(id).get();
    }

    public List<AppBuilding> getAllAppBuildings() {

        return this.appBuildingRepository.findAll();
    }

    public AppBuilding getAppBuildingByName(String name) {

        return this.appBuildingRepository.findAppBuildingsByName(name).get();
    }




}
