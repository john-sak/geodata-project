package com.devdynasty.CrowdCritic.repository;

import com.devdynasty.CrowdCritic.model.Prefecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrefectureRepository extends JpaRepository<Prefecture,Integer> {

    @Override
    Optional<Prefecture> findById(Integer integer);

    Optional<Prefecture> findPrefectureByName(String name);


}
