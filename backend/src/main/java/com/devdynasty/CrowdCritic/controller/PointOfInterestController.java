package com.devdynasty.CrowdCritic.controller;

import com.devdynasty.CrowdCritic.dto.PointOfInterestDTO;
import com.devdynasty.CrowdCritic.exception.PointOfInterestNotFoundException;
import com.devdynasty.CrowdCritic.model.*;
import com.devdynasty.CrowdCritic.repository.PointOfInterestRepository;
import com.devdynasty.CrowdCritic.service.CategoryService;
import com.devdynasty.CrowdCritic.service.PointOfInterestService;
import com.devdynasty.CrowdCritic.service.PrefectureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/poi")
@CrossOrigin
public class PointOfInterestController {

    private final PointOfInterestService pointOfInterestService;
    private final CategoryService categoryService;
    private final PrefectureService prefectureService;

    public PointOfInterestController(PointOfInterestService pointOfInterestService, PointOfInterestRepository pointOfInterestRepository, CategoryService categoryService, PrefectureService prefectureService) {

        this.pointOfInterestService = pointOfInterestService;
        this.categoryService = categoryService;
        this.prefectureService = prefectureService;
    }

    @GetMapping
    public ResponseEntity<List<PointOfInterest>> getAll() {

        return ResponseEntity.status(HttpStatus.OK).body(pointOfInterestService.findAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PointOfInterest> getById(@PathVariable Integer id) throws PointOfInterestNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(pointOfInterestService.findPointOfInterestById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PointOfInterest> getByName(@PathVariable String name) throws PointOfInterestNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(this.pointOfInterestService.findPointOfInterestByName(name));
    }

    @PostMapping("/search") // /api/poi/search instead of /search/pois
    public ResponseEntity<SearchResponseBody> search(@RequestBody SearchRequestBody request) {

        boolean allNull = false;
        List<PointOfInterest> set1 = new ArrayList<PointOfInterest>();
        List<PointOfInterest> set2 = new ArrayList<PointOfInterest>();
        List<PointOfInterest> set3 = new ArrayList<PointOfInterest>();
        List<PointOfInterest> set4 = new ArrayList<PointOfInterest>();

        if (!(request.getText() == null || request.getText().isEmpty() || request.getText().isBlank())) {

            set1 = this.pointOfInterestService.searchEverywhere(request.getText());
            if (set1.isEmpty()) allNull = true;
        }

        if (!allNull && request.getFilters().getDistance().getKm() > 0) {

            set2 = this.pointOfInterestService.searchDistance(request.getFilters().getDistance());
            if (set2.isEmpty()) allNull = true;
        }

        if (!allNull && !(request.getFilters().getKeywords() == null || request.getFilters().getKeywords().isEmpty())) {

            set3 = this.pointOfInterestService.searchKeywords(request.getFilters().getKeywords());
            if (set3.isEmpty()) allNull = true;
        }

        if (!allNull && !(request.getFilters().getCategories() == null || request.getFilters().getCategories().isEmpty())) {

            set4 = this.pointOfInterestService.searchCategories(request.getFilters().getCategories());
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

        return ResponseEntity.status(HttpStatus.OK).body(new SearchResponseBody(request.getStart(), request.getCount(), pois.size(), out));
    }

    @PostMapping("/import")
    public ResponseEntity<List<PointOfInterest>> importPointsOfInterest(@RequestParam("file") MultipartFile file) throws PointOfInterestNotFoundException {

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

                pointOfInterestService.savePointOfInterest(poi);
            }
        } catch (IOException e) {
//          // Handle the exception
        }

        return ResponseEntity.status(HttpStatus.OK).body(pois);
    }
}
