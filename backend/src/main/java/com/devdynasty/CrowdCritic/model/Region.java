package com.devdynasty.CrowdCritic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String name;


}
