package com.devdynasty.CrowdCritic.controller;



import com.devdynasty.CrowdCritic.model.Prefecture;
import com.devdynasty.CrowdCritic.service.PrefectureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/prefecture")
public class PrefectureController {


    private final PrefectureService prefectureService;


    public PrefectureController(PrefectureService prefectureService) {
        this.prefectureService = prefectureService;
    }


    @GetMapping
    public ResponseEntity<List<Prefecture>> getAll(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        prefectureService
                                .getAll()
                );

    }


    @GetMapping("/id/{id}")
    public ResponseEntity<Prefecture> findById(@PathVariable Integer id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        prefectureService
                .findPrefectureById(id)
                );

    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Prefecture> findByName(@PathVariable String name){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        prefectureService
                .findPrefectureByName(name)
                );
    }


}
