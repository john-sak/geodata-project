package com.devdynasty.CrowdCritic.repository;

import com.devdynasty.CrowdCritic.model.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KeywordRespository extends JpaRepository<Keyword,Integer> {

    @Override
    Optional<Keyword> findById(Integer integer);

    Optional<Keyword> findKeywordByName(String name);


}
