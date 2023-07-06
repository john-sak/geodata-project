package com.devdynasty.CrowdCritic.service;


import com.devdynasty.CrowdCritic.model.AreaOfInterest;
import com.devdynasty.CrowdCritic.repository.AreaOfInterestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaOfInterestService {


    private final AreaOfInterestRepository areaOfInterestRepository;


    public AreaOfInterestService(AreaOfInterestRepository areaOfInterestRepository) {
        this.areaOfInterestRepository = areaOfInterestRepository;
    }


    //TODO return DAO NOT EXPOSING USERS INFO
    public List<AreaOfInterest> getAll() {

      return   this.areaOfInterestRepository.findAll();

    }
}
