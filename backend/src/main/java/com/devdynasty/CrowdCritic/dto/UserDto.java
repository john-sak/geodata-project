package com.devdynasty.CrowdCritic.dto;

import com.devdynasty.CrowdCritic.model.AppUser;
import com.devdynasty.CrowdCritic.model.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class UserDto {

    private Integer id;


    private String name;

    private String surname;


    private String username;

    private String email;

    private String phoneNumber;

    private Role role;


    public UserDto(AppUser user) {
        this.id=user.getId();
        this.username=user.getUsername();
        this.email=user.getEmail();
        this.role=user.getRole();
        this.phoneNumber=user.getPhoneNumber();
    }




}
