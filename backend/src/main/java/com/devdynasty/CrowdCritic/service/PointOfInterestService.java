package com.devdynasty.CrowdCritic.service;

import com.devdynasty.CrowdCritic.model.PointOfInterest;
import com.devdynasty.CrowdCritic.repository.PointOfInterestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointOfInterestService {

    PointOfInterestRepository pointOfInterestRepository;



    public PointOfInterestService(PointOfInterestRepository pointOfInterestRepository) { this.pointOfInterestRepository = pointOfInterestRepository; }


    public PointOfInterest getAppBuildingById(Integer id) {

        return this.pointOfInterestRepository.findById(id).get();
    }

    public List<PointOfInterest> getAllAppBuildings() {

        return this.pointOfInterestRepository.findAll();
    }

    public PointOfInterest getAppBuildingByName(String name) {

        return this.pointOfInterestRepository.findAppBuildingsByName(name).get();
    }




}
