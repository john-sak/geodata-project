package com.devdynasty.CrowdCritic.service;


import com.devdynasty.CrowdCritic.dto.AreaOfInterestDTO;
import com.devdynasty.CrowdCritic.dto.UserDto;
import com.devdynasty.CrowdCritic.exception.AreaOfInterestNotFoundException;
import com.devdynasty.CrowdCritic.model.AppUser;
import com.devdynasty.CrowdCritic.model.AreaOfInterest;
import com.devdynasty.CrowdCritic.repository.AppUserRepository;
import com.devdynasty.CrowdCritic.repository.AreaOfInterestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaOfInterestService {


    private final AreaOfInterestRepository areaOfInterestRepository;
    private final AppUserRepository appUserRepository;


    public AreaOfInterestService(AreaOfInterestRepository areaOfInterestRepository,
                                 AppUserRepository appUserRepository) {
        this.areaOfInterestRepository = areaOfInterestRepository;
        this.appUserRepository = appUserRepository;
    }


    public List<AreaOfInterestDTO> getAll() {


      return   this.
              areaOfInterestRepository
              .findAll().stream()
              .map(AreaOfInterestDTO::new)
              .toList();

    }


    public List<AreaOfInterestDTO> getByAppUser(AppUser appuser) throws AreaOfInterestNotFoundException {


        List<AreaOfInterestDTO> list = areaOfInterestRepository
                .findAreaOfInterestSByAppUsers(appuser)
                .orElseThrow(()->new AreaOfInterestNotFoundException(
                        "AREAOFINTEREST_NOT_FOUND_FOR_"+appuser.getUsername().toUpperCase()+"."
                ))
                .stream()
                .map(AreaOfInterestDTO::new)
                .toList();

        return list;

    }




}
