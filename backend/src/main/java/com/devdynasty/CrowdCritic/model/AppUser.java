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
public class AppUser {

    @Id
    private Integer id;


    private String name;

    private String surname;


    private String username;

    private String email;

    private String phoneNumber;

    private Role role;

}
