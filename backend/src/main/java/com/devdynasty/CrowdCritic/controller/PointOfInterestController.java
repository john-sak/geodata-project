package com.devdynasty.CrowdCritic.controller;

import com.devdynasty.CrowdCritic.model.PointOfInterest;
import com.devdynasty.CrowdCritic.service.PointOfInterestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/building")
public class PointOfInterestController {

    private final PointOfInterestService pointOfInterestService;

    public PointOfInterestController(PointOfInterestService pointOfInterestService) { this.pointOfInterestService = pointOfInterestService; }

    @GetMapping
    public ResponseEntity<List<PointOfInterest>> getAllAppBuildings() {

        return ResponseEntity.status(HttpStatus.OK).body(this.pointOfInterestService.getAllAppBuildings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PointOfInterest> getById(@PathVariable Integer id) {

        return ResponseEntity.status(HttpStatus.OK).body(this.pointOfInterestService.getAppBuildingById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PointOfInterest> getByName(@PathVariable String name) {

        return ResponseEntity.status(HttpStatus.OK).body(this.pointOfInterestService.getAppBuildingByName(name));
    }


}
