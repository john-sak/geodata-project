package com.devdynasty.CrowdCritic.service;

import com.devdynasty.CrowdCritic.exception.KeyWordNotFoundException;
import com.devdynasty.CrowdCritic.model.Keyword;
import com.devdynasty.CrowdCritic.repository.KeywordRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordService {

    private final KeywordRespository keywordRespository;


    public KeywordService(KeywordRespository keywordRespository) {
        this.keywordRespository = keywordRespository;
    }

    public Keyword findKeywordById(Integer id) throws KeyWordNotFoundException {

        return keywordRespository
                .findById(id)
                .orElseThrow(() ->new KeyWordNotFoundException("Keyword with id "+id+" not found"));

    }


    public Keyword findKeywordByName(String name) throws KeyWordNotFoundException {

        return keywordRespository
                .findKeywordByName(name)
                .orElseThrow(() ->new KeyWordNotFoundException("Keyword with name "+name+" not found"));

    }


    public List<Keyword> findAll() {

        return keywordRespository
                .findAll();
    }

    public Keyword saveKeyword(Keyword keyword) {

        return keywordRespository.
                findKeywordByName(keyword.getName())
                .orElseGet(() -> keywordRespository
                        .save(keyword));

    }
}
