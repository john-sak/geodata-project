package com.devdynasty.CrowdCritic.service;


import com.devdynasty.CrowdCritic.dto.AreaOfInterestDTO;
import com.devdynasty.CrowdCritic.dto.UserDto;
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


    public List<AreaOfInterestDTO> getAll() {


      return   this.
              areaOfInterestRepository
              .findAll().stream()
              .map(AreaOfInterestDTO::new)
              .toList();

    }

    //TODO by username
    public AreaOfInterestDTO getByUserName(String username){

        return null;

    }




}
