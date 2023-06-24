package com.devdynasty.CrowdCritic.controller;

import com.devdynasty.CrowdCritic.model.PointOfInterest;
import com.devdynasty.CrowdCritic.model.SearchRequestBody;
import com.devdynasty.CrowdCritic.model.SearchResponseBody;
import com.devdynasty.CrowdCritic.service.PointOfInterestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/poi")
public class PointOfInterestController {

    private final PointOfInterestService pointOfInterestService;

    public PointOfInterestController(PointOfInterestService pointOfInterestService) { this.pointOfInterestService = pointOfInterestService; }

    @GetMapping
    public ResponseEntity<List<PointOfInterest>> getAllPointsOfInterest() {

        return ResponseEntity.status(HttpStatus.OK).body(this.pointOfInterestService.getAllPointsOfInterest());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PointOfInterest> getById(@PathVariable Integer id) {

        return ResponseEntity.status(HttpStatus.OK).body(this.pointOfInterestService.getPointOfInterestById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PointOfInterest> getByName(@PathVariable String name) {

        return ResponseEntity.status(HttpStatus.OK).body(this.pointOfInterestService.getPointOfInterestByName(name));
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

            set4 = this.pointOfInterestService.searchCategories(request.getFilters().getCategories()); // todo: errors when spaces in name
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

        return ResponseEntity.status(HttpStatus.OK).body(new SearchResponseBody(request.getStart(), request.getCount(), pois.size(), new ArrayList<PointOfInterest>(pois)));
    }
}
