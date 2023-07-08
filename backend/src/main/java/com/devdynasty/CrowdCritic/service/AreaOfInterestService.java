package com.devdynasty.CrowdCritic.service;


import com.devdynasty.CrowdCritic.dto.AreaOfInterestDTO;
import com.devdynasty.CrowdCritic.exception.AreaOfInterestNotFoundException;
import com.devdynasty.CrowdCritic.model.AppUser;
import com.devdynasty.CrowdCritic.model.AreaOfInterest;
import com.devdynasty.CrowdCritic.repository.AppUserRepository;
import com.devdynasty.CrowdCritic.repository.AreaOfInterestRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaOfInterestService {


    private final AreaOfInterestRepository areaOfInterestRepository;
    private final AppUserRepository appUserRepository;
    private final TokenService tokenService;


    public AreaOfInterestService(AreaOfInterestRepository areaOfInterestRepository,
                                 AppUserRepository appUserRepository, TokenService tokenService) {
        this.areaOfInterestRepository = areaOfInterestRepository;
        this.appUserRepository = appUserRepository;
        this.tokenService = tokenService;
    }


    public List<AreaOfInterestDTO> getAll() {


      return   this.
              areaOfInterestRepository
              .findAll().stream()
              .map(AreaOfInterestDTO::new)
              .toList();

    }


    public List<AreaOfInterestDTO> getByAppUser(AppUser appuser) throws AreaOfInterestNotFoundException {


        List<AreaOfInterestDTO> list = areaOfInterestRepository
                .findByAppUsers_UsernameLike(appuser.getUsername())
                .stream()
                .map(AreaOfInterestDTO::new)
                .toList();

        return list;

    }


    //TODO TESTING
    public AreaOfInterestDTO save(AreaOfInterestDTO areaOfInterestDTO) {


       AppUser user= this.appUserRepository.findAppUsersByUsername(
               areaOfInterestDTO
                .getAppUsers()
                .get(0)
                .getUsername()
               )
                 .orElseThrow(()->new UsernameNotFoundException(""));



       AreaOfInterest savedAoi=  areaOfInterestRepository
               .save(
                       new AreaOfInterest
                               (
                                       areaOfInterestDTO,
                                       List.of(
                                               user
                                       )
                               )
        );

       return new AreaOfInterestDTO(savedAoi);

    }


    public List<AreaOfInterestDTO> getMyAreaOfInterest(String token) {

        String jwt = token.substring(7);


        String username=tokenService.extractUsername(jwt);


        List <AreaOfInterest> areasOfInterests = areaOfInterestRepository
                .findByAppUsers_UsernameLike(
                          username
                );




        return areasOfInterests
                .stream()
                .map(AreaOfInterestDTO::new)
                .toList();


    }
}
