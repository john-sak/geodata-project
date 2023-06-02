package com.devdynasty.CrowdCritic.service;

import com.devdynasty.CrowdCritic.model.PointOfInterest;
import com.devdynasty.CrowdCritic.repository.PointOfInterestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointOfInterestService {

    PointOfInterestRepository pointOfInterestRepository;



    public PointOfInterestService(PointOfInterestRepository pointOfInterestRepository) { this.pointOfInterestRepository = pointOfInterestRepository; }


    public PointOfInterest getPointOfInterestById(Integer id) {

        return this.pointOfInterestRepository.findById(id).get();
    }

    public List<PointOfInterest> getAllPointsOfInterest() {

        return this.pointOfInterestRepository.findAll();
    }

    public PointOfInterest getPointOfInterestByName(String name) {

        return this.pointOfInterestRepository.findAppBuildingsByName(name).get();
    }




}
