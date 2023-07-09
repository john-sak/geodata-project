package com.devdynasty.CrowdCritic.controller;

import com.devdynasty.CrowdCritic.exception.PointOfInterestNotFoundException;
import com.devdynasty.CrowdCritic.model.PointOfInterest;
import com.devdynasty.CrowdCritic.model.SearchRequestBody;
import com.devdynasty.CrowdCritic.model.SearchResponseBody;
import com.devdynasty.CrowdCritic.repository.PointOfInterestRepository;
import com.devdynasty.CrowdCritic.service.CategoryService;
import com.devdynasty.CrowdCritic.service.PointOfInterestService;
import com.devdynasty.CrowdCritic.service.PrefectureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/poi")
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

        return ResponseEntity.status(HttpStatus.OK).body(this.pointOfInterestService.search(request));
    }

    @PostMapping("/import")
    public ResponseEntity<List<PointOfInterest>> importPointsOfInterest(@RequestParam("file") MultipartFile file) throws PointOfInterestNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(this.pointOfInterestService.importPOIs(file));
    }
}
