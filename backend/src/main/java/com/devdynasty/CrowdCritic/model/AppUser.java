package com.devdynasty.CrowdCritic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
