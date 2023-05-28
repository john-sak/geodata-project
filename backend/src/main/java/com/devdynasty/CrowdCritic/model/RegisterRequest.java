package com.devdynasty.CrowdCritic.model;

import lombok.*;

@Builder
@NoArgsConstructor
@Setter
@Getter
public class RegisterRequest {

    private String name;
    private String surname;
    private String username;
    private String phoneNumber;
    private String email;
    private String password;
    private Role role;

    public RegisterRequest(String name, String surname, String username, String phoneNumber, String email, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }



}
