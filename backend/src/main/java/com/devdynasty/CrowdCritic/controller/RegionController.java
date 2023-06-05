package com.devdynasty.CrowdCritic.controller;

import com.devdynasty.CrowdCritic.model.Region;
import com.devdynasty.CrowdCritic.service.RegionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/region")
public class RegionController {

    private final RegionService regionService;


    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }


    @GetMapping
    public ResponseEntity<List<Region>> getAllRegions() {
        return ResponseEntity.status(HttpStatus.OK).body(this.regionService.getAllRegions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> getById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.regionService.getRegionById(id).get());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Region> getByUsername(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(this.regionService.getRegionByName(name).get());

    }


//
//    @PostMapping
//    public ResponseEntity<String> createRegion(@RequestBody Region region){
//
//        var region= Optional.of(this.regionService.(region));
//
//        if (region.isEmpty())
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("AppUser Not Created");
//
//        return ResponseEntity.status(HttpStatus.CREATED).body("Region Created");
//
//    }





}
