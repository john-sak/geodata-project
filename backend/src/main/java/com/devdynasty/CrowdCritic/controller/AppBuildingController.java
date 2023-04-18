package com.devdynasty.CrowdCritic.controller;

import com.devdynasty.CrowdCritic.model.AppBuilding;
import com.devdynasty.CrowdCritic.service.AppBuildingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/building")
public class AppBuildingController {

    private final AppBuildingService appBuildingService;

    public AppBuildingController(AppBuildingService appBuildingService) { this.appBuildingService = appBuildingService; }

    @GetMapping
    public ResponseEntity<List<AppBuilding>> getAllAppBuildings() {

        return ResponseEntity.status(HttpStatus.OK).body(this.appBuildingService.getAllAppBuildings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppBuilding> getById(@PathVariable Integer id) {

        return ResponseEntity.status(HttpStatus.OK).body(this.appBuildingService.getAppBuildingById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<AppBuilding> getByName(@PathVariable String name) {

        return ResponseEntity.status(HttpStatus.OK).body(this.appBuildingService.getAppBuildingByName(name));
    }


}
