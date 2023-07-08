package com.devdynasty.CrowdCritic.controller;

import com.devdynasty.CrowdCritic.dto.AreaOfInterestDTO;
import com.devdynasty.CrowdCritic.model.AreaOfInterest;
import com.devdynasty.CrowdCritic.service.AreaOfInterestService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity
                .status(
                        HttpStatus
                                .OK
                )
                .body(
                        areaOfInterestService
                                .getAll()
                );
    }


    @PostMapping("post")
    public ResponseEntity<AreaOfInterestDTO> post(AreaOfInterestDTO areaOfInterestDTO ){


        return ResponseEntity
                .status(
                        HttpStatus
                                .OK
                ).body(
                        areaOfInterestService
                                .save(
                                        areaOfInterestDTO
                                )
                );


    }


    @GetMapping("mine")
    public ResponseEntity<List<AreaOfInterestDTO>> getMyAreaOfInterest(@RequestHeader (name="Authorization") String token){


       return ResponseEntity
               .status(
                       HttpStatus
                               .OK
               )
               .body(
                       areaOfInterestService
                               .getMyAreaOfInterest(token)
               );





    }













}
