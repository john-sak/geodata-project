package com.devdynasty.CrowdCritic.model;

import lombok.*;

@Builder
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class RegisterRequest {

    private String name;
    private String surname;
    private String username;
    private String phoneNumber;
    private String email;
    private String password;



}
