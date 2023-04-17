package com.devdynasty.CrowdCritic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
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


    @NotNull
    @NotBlank
    @Size(min=4,max= 30,message = "name should be between 4 and 30 characters")
    private String name;

    @NotNull
    @NotBlank
    @Size(min=4,max=30,message = "surname should be between 4 and 30 characters")
    private String surname;


    @NotNull
    @NotBlank
    @Size(min=4,message = "username should be between 4 and 30 characters")
    private String username;

    @NotBlank
    @NotNull
    @Email(message = "not email type")
    private String email;

    @NotBlank
    @NotNull
    @Digits(fraction = 0,integer = 10)
    private String phoneNumber;


    private Role role;

}
