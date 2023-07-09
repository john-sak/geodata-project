package com.devdynasty.CrowdCritic.model;


import com.devdynasty.CrowdCritic.dto.AreaOfInterestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor(force = true)
public class AreaOfInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private Double latitude;
    @NonNull
    private Double longitude;

    @NonNull
    private Integer distance;

    //TODO COLUMN NAME DB
    @ManyToOne
    @NotNull
    @JoinColumn(name="appuser_id")
    private AppUser appUser;


    public AreaOfInterest(AreaOfInterestDTO areaOfInterestDTO, AppUser user) {
        this.appUser=user;
        this.distance=areaOfInterestDTO.getDistance();
        this.longitude= areaOfInterestDTO.getLongitude();
        this.latitude=areaOfInterestDTO.getLatitude();

    }
}
