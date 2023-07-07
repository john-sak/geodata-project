package com.devdynasty.CrowdCritic.repository;

import com.devdynasty.CrowdCritic.model.AppUser;
import com.devdynasty.CrowdCritic.model.AreaOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AreaOfInterestRepository extends JpaRepository<AreaOfInterest, Integer> {


    public Optional<List<AreaOfInterest>> findAreaOfInterestSByAppUsers(AppUser appUser);


}
