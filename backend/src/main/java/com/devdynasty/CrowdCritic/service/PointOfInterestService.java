package com.devdynasty.CrowdCritic.service;

import com.devdynasty.CrowdCritic.model.Distance;
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

        return this.pointOfInterestRepository.findPointsOfInterestByName(name).get();
    }




    public List<PointOfInterest> searchEverywhere(String text) {

        String[] words = text.split("[^\\p{IsGreek}\\p{IsLatin}]+");
        String query = String.join(" & ", words);

        return this.pointOfInterestRepository.findEverywhere(query);
    }

    public List<PointOfInterest> searchDistance(Distance distance) {

        return this.pointOfInterestRepository.findByDistance(distance.getLat(), distance.getLon(), distance.getKm() * 1000);
    }

    public List<PointOfInterest> searchKeywords(List<String> keywords) {

        String query = keywords.get(0);
        for (int i = 1; i < keywords.size(); i++) query = query.concat(" | " + keywords.get(i));

        return this.pointOfInterestRepository.findByKeyword(query);
    }

    public List<PointOfInterest> searchCategories(List<String> categories) {

        String query = categories.get(0);
        for (int i = 1; i < categories.size(); i++) query = query.concat(" | " + categories.get(i));

        return this.pointOfInterestRepository.findByCategory(query);
    }
}
