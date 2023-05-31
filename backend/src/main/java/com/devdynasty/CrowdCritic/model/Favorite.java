package com.devdynasty.CrowdCritic.model;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Favorite {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "appuser_id")
    AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "appbuilding_id")
    PointOfInterest pointOfInterest;



}
