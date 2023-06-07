package com.devdynasty.CrowdCritic.service;

import com.devdynasty.CrowdCritic.model.PointOfInterest;
import com.devdynasty.CrowdCritic.model.SearchRequestBody;
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

        return this.pointOfInterestRepository.findPointsOfInterestByName(name).get();
    }




    public List<PointOfInterest> searchEverywhere(String text) {

        return this.pointOfInterestRepository.findEverywhere(text);
    }

    public List<PointOfInterest> searchDistance(SearchRequestBody.Filters.Distance distance) {

        Double latMin, latMax, lonMin, lonMax;

        //TODO

        latMin = 0.0;
        latMax = 0.0;
        lonMin = 0.0;
        lonMax = 0.0;

        return this.pointOfInterestRepository.findByDistance(latMin, latMax, lonMin, lonMax);
    }

    public List<PointOfInterest> searchKeyword(String keyword) {

        return this.pointOfInterestRepository.findByKeyword(keyword);
    }

    public List<PointOfInterest> searchCategory(String category) {

        return this.pointOfInterestRepository.findByCategory(category);
    }
}
