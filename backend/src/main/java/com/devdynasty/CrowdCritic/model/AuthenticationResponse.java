package com.devdynasty.CrowdCritic.model;


import com.devdynasty.CrowdCritic.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class AuthenticationResponse {


    private UserDto userDto;

    private String accessToken;

    private String refreshToken;





}
