package com.devdynasty.CrowdCritic.model;


import com.devdynasty.CrowdCritic.dto.AreaOfInterestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedEntityGraph;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AreaOfInterest {

    @Id
    private Integer id;

    @NonNull
    private Double latitude;
    @NonNull
    private Double longitude;

    @NonNull
    private Integer distance;

    //TODO COLUMN NAME DB
    @ManyToMany
    private List<AppUser> appUsers;


    public AreaOfInterest(AreaOfInterestDTO areaOfInterestDTO, List<AppUser> users) {
        this.appUsers=users;
        this.distance=areaOfInterestDTO.getDistance();
        this.longitude= areaOfInterestDTO.getLongitude();
        this.latitude=areaOfInterestDTO.getLatitude();

    }
}
