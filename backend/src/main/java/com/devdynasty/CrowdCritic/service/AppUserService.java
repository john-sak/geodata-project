package com.devdynasty.CrowdCritic.service;

import com.devdynasty.CrowdCritic.model.AppUser;
import com.devdynasty.CrowdCritic.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppUserService implements UserDetailsService {

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

    public AppUser createAppUser(AppUser appUser){
        return this.appUserRepository.save(appUser);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.appUserRepository.findAppUsersByUsername(username).get();
    }
}
