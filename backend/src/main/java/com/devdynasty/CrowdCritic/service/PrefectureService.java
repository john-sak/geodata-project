package com.devdynasty.CrowdCritic.service;


import com.devdynasty.CrowdCritic.exception.PrefectureNotFoundException;
import com.devdynasty.CrowdCritic.model.Prefecture;
import com.devdynasty.CrowdCritic.model.Region;
import com.devdynasty.CrowdCritic.repository.PrefectureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrefectureService {

   private final PrefectureRepository prefectureRepository;
    private final RegionService regionService;


    public PrefectureService(PrefectureRepository prefectureRepository, RegionService regionService) {
        this.prefectureRepository = prefectureRepository;
        this.regionService = regionService;
    }


    public List<Prefecture> getAll(){

        return prefectureRepository
                .findAll();
    }

    public Prefecture findPrefectureById(Integer id) throws PrefectureNotFoundException {

        return prefectureRepository
                .findById(id)
                .orElseThrow(() -> new PrefectureNotFoundException("Prefecture with  id "+id+" not found"));

    }


    public Prefecture findPrefectureByName(String name) throws PrefectureNotFoundException {

        return prefectureRepository
                .findPrefectureByName(name)
                .orElseThrow(() -> new PrefectureNotFoundException("Prefecture with  name "+name+" not found"));


    }


    public Prefecture savePrefecture(Prefecture prefecture) {


        return prefectureRepository.
                findPrefectureByName(prefecture.getName())
                .orElseGet(
                        () ->{
                                  Region r = new Region();
                                  r.setName("--");
                                  r=regionService.saveRegion(r);
                                  prefecture.setRegion(r);
                                  return prefectureRepository.save(prefecture);

                        }

                );


    }

}

