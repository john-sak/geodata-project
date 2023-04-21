package com.devdynasty.CrowdCritic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PointOfInterest {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "appuser_id")
    AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "appbuilding_id")
    AppBuilding appBuilding;



}
