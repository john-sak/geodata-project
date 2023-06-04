package com.devdynasty.CrowdCritic.controller;

import com.devdynasty.CrowdCritic.model.PointOfInterest;
import com.devdynasty.CrowdCritic.model.SearchRequestBody;
import com.devdynasty.CrowdCritic.model.SearchResponseBody;
import com.devdynasty.CrowdCritic.service.PointOfInterestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @PostMapping("/search") // /api/poi//search instead of /search/pois
    public SearchResponseBody search(@RequestBody SearchRequestBody request) {

        SearchResponseBody response = new SearchResponseBody();

        String freeText = request.getText();

        SearchRequestBody.Filters.Distance distance = request.getFilters().getDistance();

        List<String> keywords = request.getFilters().getKeywords();

        List<String> categories = request.getFilters().getCategories();

        //TODO

        return response;
    }
}
