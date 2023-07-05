package com.devdynasty.CrowdCritic.controller;


import com.devdynasty.CrowdCritic.model.Keyword;
import com.devdynasty.CrowdCritic.repository.KeywordRespository;
import com.devdynasty.CrowdCritic.exception.KeyWordNotFoundException;
import com.devdynasty.CrowdCritic.service.KeywordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/keyword")
@CrossOrigin
public class KeywordController {


    private final KeywordService keywordService;


    public KeywordController(KeywordService keywordService,
                             KeywordRespository keywordRespository) {
        this.keywordService = keywordService;

    }


    @GetMapping
    public ResponseEntity<List<Keyword>> getAll() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        keywordService
                                .findAll()
                );

    }


    @GetMapping("/id/{id}")
    public ResponseEntity<Keyword> findById(@PathVariable Integer id) throws KeyWordNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        keywordService
                                .findKeywordById(id)
                );

    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Keyword> findByName(@PathVariable String name) throws KeyWordNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        keywordService
                                .findKeywordByName(name)
                );
    }



    @PostMapping("/post")
    public ResponseEntity<Keyword> savePrefecture(@RequestBody Keyword keyword){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        keywordService
                                .saveKeyword(keyword)
                );

    }


}
