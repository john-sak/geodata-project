package com.devdynasty.CrowdCritic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationRequest {


    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;


}
