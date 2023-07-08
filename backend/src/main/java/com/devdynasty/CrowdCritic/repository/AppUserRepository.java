package com.devdynasty.CrowdCritic.repository;

import com.devdynasty.CrowdCritic.model.AppUser;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {


     @Override
     Optional<AppUser> findById(Integer id);


     List<AppUser> findAll();


     Optional<AppUser> findAppUsersByUsername(String username);

     Optional<AppUser> findAppUserByEmail(String email);

}
