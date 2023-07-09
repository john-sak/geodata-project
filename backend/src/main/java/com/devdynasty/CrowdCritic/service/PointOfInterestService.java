package com.devdynasty.CrowdCritic.service;

import com.devdynasty.CrowdCritic.dto.PointOfInterestDTO;
import com.devdynasty.CrowdCritic.exception.PointOfInterestNotFoundException;
import com.devdynasty.CrowdCritic.model.*;
import com.devdynasty.CrowdCritic.repository.PointOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PointOfInterestService {

    public final PointOfInterestRepository pointOfInterestRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PrefectureService prefectureService;

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

    public SearchResponseBody search(SearchRequestBody request) {

        boolean allNull = false;
        List<PointOfInterest> set1 = new ArrayList<PointOfInterest>();
        List<PointOfInterest> set2 = new ArrayList<PointOfInterest>();
        List<PointOfInterest> set3 = new ArrayList<PointOfInterest>();
        List<PointOfInterest> set4 = new ArrayList<PointOfInterest>();

        if (!(request.getText() == null || request.getText().isEmpty() || request.getText().isBlank())) {

            set1 = searchEverywhere(request.getText());
            if (set1.isEmpty()) allNull = true;
        }

        if (!allNull && request.getFilters().getDistance().getKm() > 0) {

            set2 = searchDistance(request.getFilters().getDistance());
            if (set2.isEmpty()) allNull = true;
        }

        if (!allNull && !(request.getFilters().getKeywords() == null || request.getFilters().getKeywords().isEmpty())) {

            set3 = searchKeywords(request.getFilters().getKeywords());
            if (set3.isEmpty()) allNull = true;
        }

        if (!allNull && !(request.getFilters().getCategories() == null || request.getFilters().getCategories().isEmpty())) {

            set4 = searchCategories(request.getFilters().getCategories());
            if (set4.isEmpty()) allNull = true;
        }

        Set<PointOfInterest> pois = new HashSet<PointOfInterest>();

        if (!allNull) {

            List<List<PointOfInterest>> nonEmptyLists = new ArrayList<>();
            if (!set1.isEmpty()) nonEmptyLists.add(set1);
            if (!set2.isEmpty()) nonEmptyLists.add(set2);
            if (!set3.isEmpty()) nonEmptyLists.add(set3);
            if (!set4.isEmpty()) nonEmptyLists.add(set4);

            if (!nonEmptyLists.isEmpty()) {
                pois.addAll(nonEmptyLists.get(0));
                for (int i = 1; i < nonEmptyLists.size(); i++) pois.retainAll(nonEmptyLists.get(i));
            }
        }

        List<PointOfInterestDTO> out = new ArrayList<PointOfInterestDTO>();
        for (PointOfInterest poi: pois) out.add(new PointOfInterestDTO(poi));

        return new SearchResponseBody(request.getStart(), request.getCount(), pois.size(), out);
    }

    public List<PointOfInterest> importPOIs(MultipartFile file) throws PointOfInterestNotFoundException {

        List<PointOfInterest> pois = new ArrayList<PointOfInterest>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            String line;
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");
                String poiDescription = data[0].trim();
                Double poiLat = Double.valueOf(data[1].trim());
                Double poiLon = Double.valueOf(data[2].trim());
                String poiName = data[3].trim();
                Category poiCategory = categoryService.saveCategory(new Category(data[4].trim()));
                Prefecture poiPrefecture = prefectureService.savePrefecture(new Prefecture(data[5].trim()));
                String poiAddress = data[6].trim();

                PointOfInterest poi = new PointOfInterest(poiName, poiDescription, poiPrefecture, null, poiCategory, poiLat, poiLon, poiAddress);
                pois.add(poi);

                savePointOfInterest(poi);
            }
        } catch (IOException e) {
//          // Handle the exception
        }

        return pois;
    }
}
