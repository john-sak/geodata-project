package com.devdynasty.CrowdCritic.service;


import com.devdynasty.CrowdCritic.exception.PrefectureNotFoundException;
import com.devdynasty.CrowdCritic.model.Prefecture;
import com.devdynasty.CrowdCritic.repository.PrefectureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrefectureService {

   private final PrefectureRepository prefectureRepository;


    public PrefectureService(PrefectureRepository prefectureRepository) {
        this.prefectureRepository = prefectureRepository;
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
                .orElseGet(() -> prefectureRepository
                .save(prefecture));


    }

}

