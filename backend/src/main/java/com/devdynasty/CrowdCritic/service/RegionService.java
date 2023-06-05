package com.devdynasty.CrowdCritic.service;

import com.devdynasty.CrowdCritic.model.Region;
import com.devdynasty.CrowdCritic.repository.RegionRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    private final RegionRepository regionRepository;


    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }


    public List<Region> getAllRegions(){

        return  this.regionRepository.findAll();


    }
    public Optional<Region> getRegionById(Integer id){
       return  regionRepository.findById(id);
    }






    public Optional<Region> getRegionByName(String name){
        return regionRepository.findRegionsByName(name);
    }





}
