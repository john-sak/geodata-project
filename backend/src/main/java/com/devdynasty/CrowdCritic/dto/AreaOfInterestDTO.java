package com.devdynasty.CrowdCritic.dto;

import com.devdynasty.CrowdCritic.model.AppUser;
import com.devdynasty.CrowdCritic.model.AreaOfInterest;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
@Getter
@Setter
public class AreaOfInterestDTO {

    private Integer id;

    private Double latitude;
    private Double longitude;

    private Integer distance;


    private List<UserDto> appUsers;


    public AreaOfInterestDTO(AreaOfInterest areaOfInterest){

        this.id=areaOfInterest.getId();

        this.latitude=areaOfInterest.getLatitude();

        this.longitude=areaOfInterest.getLongitude();

        this.distance=areaOfInterest.getDistance();

        this.appUsers=areaOfInterest.getAppUsers()
                .stream()
                .map(UserDto::new)
                .toList();
    }
}
