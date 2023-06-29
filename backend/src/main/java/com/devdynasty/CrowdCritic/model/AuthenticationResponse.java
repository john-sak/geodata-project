package com.devdynasty.CrowdCritic.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class AuthenticationResponse {


    private String accessToken;

    private String refreshToken;





}
