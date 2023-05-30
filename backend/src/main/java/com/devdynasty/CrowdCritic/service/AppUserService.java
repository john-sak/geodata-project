package com.devdynasty.CrowdCritic.service;

import com.devdynasty.CrowdCritic.dto.UserDto;
import com.devdynasty.CrowdCritic.model.AppUser;
import com.devdynasty.CrowdCritic.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AppUserService implements UserDetailsService {

    AppUserRepository appUserRepository;



    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public UserDto getAppUserById(Integer id){

        return new UserDto(this.appUserRepository.findById(id).get());
    }


    public List<UserDto> getAllAppUsers(){

             return  this.appUserRepository
                     .findAll()
                     .stream()
                     .map(UserDto::new)
                     .collect(Collectors.toList());



    }

    public UserDto getAppUserByUsername(String username){
        return new UserDto(this.appUserRepository.findAppUsersByUsername(username).get());
    }

    public UserDto createAppUser(AppUser appUser){
        return new UserDto(this.appUserRepository.save(appUser));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.appUserRepository.findAppUsersByUsername(username).get();
    }
}
