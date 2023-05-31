package com.devdynasty.CrowdCritic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PointOfInterest {

    @Id
    private Integer id;


    private String name;

    private String description;


    private String prefecture;

    private String city;


    private Double latitude;

    private Double longitude;
}
