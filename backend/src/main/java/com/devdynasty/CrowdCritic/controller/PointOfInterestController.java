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
    public SearchResponseBody search(@RequestBody SearchRequestBody request) {

        List<PointOfInterest> pois = new ArrayList<PointOfInterest>();

        pois.addAll(this.pointOfInterestService.searchFreeText(request.getText()));
        pois.addAll(this.pointOfInterestService.searchDistance(request.getFilters().getDistance()));
        pois.addAll(this.pointOfInterestService.searchKeywords(request.getFilters().getKeywords()));
        pois.addAll(this.pointOfInterestService.searchCategories(request.getFilters().getCategories()));

        SearchResponseBody response = new SearchResponseBody();

        response.setStart(request.getStart());
        response.setCount(request.getCount());
        response.setTotal(pois.size());
        response.setData(pois);

        return response;
    }
}
