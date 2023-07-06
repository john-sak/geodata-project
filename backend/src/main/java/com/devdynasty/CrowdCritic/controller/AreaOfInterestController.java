package com.devdynasty.CrowdCritic.controller;

import com.devdynasty.CrowdCritic.dto.AreaOfInterestDTO;
import com.devdynasty.CrowdCritic.model.AreaOfInterest;
import com.devdynasty.CrowdCritic.service.AreaOfInterestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/aoi/")
public class AreaOfInterestController {

    private final AreaOfInterestService areaOfInterestService;

    public AreaOfInterestController(AreaOfInterestService areaOfInterestService) {
        this.areaOfInterestService = areaOfInterestService;
    }

    @GetMapping("all")
    public ResponseEntity<List<AreaOfInterestDTO>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(areaOfInterestService.getAll());
    }






}
