package com.devdynasty.CrowdCritic.service;

import com.devdynasty.CrowdCritic.exception.PointOfInterestNotFoundException;
import com.devdynasty.CrowdCritic.model.Distance;
import com.devdynasty.CrowdCritic.model.PointOfInterest;
import com.devdynasty.CrowdCritic.repository.PointOfInterestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PointOfInterestService {

    public final PointOfInterestRepository pointOfInterestRepository;

    public PointOfInterestService(PointOfInterestRepository pointOfInterestRepository) {

        this.pointOfInterestRepository = pointOfInterestRepository;
    }

    public PointOfInterest findPointOfInterestById(Integer id) throws PointOfInterestNotFoundException {

        return pointOfInterestRepository
                .findById(id)
                .orElseThrow(() -> new PointOfInterestNotFoundException("PointOfInterest with id " + id + " not found"));
    }

    public PointOfInterest findPointOfInterestByName(String name) throws  PointOfInterestNotFoundException {

        return pointOfInterestRepository
                .findPointsOfInterestByName(name)
                .orElseThrow(() -> new PointOfInterestNotFoundException("PointOfInterest with name " + name + " not found"));
    }

    public List<PointOfInterest> findAll() {

        return this.pointOfInterestRepository
                .findAll();
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

        String query = String.join(" ", keywords
                .stream()
                .filter(str -> !(str.isEmpty() || str.isBlank()))
                .collect(Collectors.toList()));

        return this.pointOfInterestRepository.findByKeyword(query);
    }

    public List<PointOfInterest> searchCategories(List<String> categories) {

        List<Integer> categoryIDs = categories.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return this.pointOfInterestRepository.findByCategory(categoryIDs);
    }

    public PointOfInterest savePointOfInterest(PointOfInterest pointOfInterest) {

        return pointOfInterestRepository
                .findPointsOfInterestByName(pointOfInterest.getName())
                .orElseGet(() -> pointOfInterestRepository.save(pointOfInterest));
    }
}
