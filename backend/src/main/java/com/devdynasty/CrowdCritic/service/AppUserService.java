package com.devdynasty.CrowdCritic.service;

import com.devdynasty.CrowdCritic.model.AppUser;
import com.devdynasty.CrowdCritic.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppUserService {

    AppUserRepository appUserRepository;



    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser getAppUserById(Integer id){

        return this.appUserRepository.findById(id).get();
    }


    public List<AppUser> getAllAppUsers(){

        return this.appUserRepository.findAll();

    }

    public AppUser getAppUserByUsername(String username){
        return this.appUserRepository.findAppUsersByUsername(username).get();
    }







}
