package com.devdynasty.CrowdCritic.service;


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

    public Prefecture findPrefectureById(Integer id){

        return prefectureRepository
                .findById(id)
                .get();

    }


    public Prefecture findPrefectureByName(String name){

        return prefectureRepository
                .findPrefectureByName(name)
                .get();


    }



}

