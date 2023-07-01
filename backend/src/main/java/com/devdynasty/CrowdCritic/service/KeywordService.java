package com.devdynasty.CrowdCritic.service;

import com.devdynasty.CrowdCritic.model.Keyword;
import com.devdynasty.CrowdCritic.repository.KeywordRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class KeywordService {

    private final KeywordRespository keywordRespository;


    public KeywordService(KeywordRespository keywordRespository) {
        this.keywordRespository = keywordRespository;
    }

    public Keyword findKeywordById(Integer id) throws NoSuchElementException {

        return keywordRespository
                .findById(id)
                .get();

    }


    public Keyword findKeywordByName(String name) throws NoSuchElementException {

        return keywordRespository
                .findKeywordByWord(name)
                .get();

    }


    public List<Keyword> findAll() {

        return keywordRespository
                .findAll();
    }
}
