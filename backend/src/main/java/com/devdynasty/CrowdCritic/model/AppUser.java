package com.devdynasty.CrowdCritic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

import static com.devdynasty.CrowdCritic.model.Role.ADMIN;
import static com.devdynasty.CrowdCritic.model.Role.USER;
import static jakarta.persistence.GenerationType.IDENTITY;

//TODO username must be unique
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "appuser_id")
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
    @Column(unique = true)
    @Size(min=4,message = "username should be between 4 and 30 characters")
    private String username;

    @NotBlank
    @NotNull
    @Column(unique = true)
    @Email(message = "not email type")
    private String email;

    @NotBlank
    @NotNull
    @Digits(fraction = 0,integer = 10)
    private String phoneNumber;


    @NotNull
    @Size(min = 8)
    private String password;



    @NotNull
    private Role role;


    private GrantedAuthority authorities;


    @Column(columnDefinition = "boolean default true")
    private boolean accountNonExpired;

    @Column(columnDefinition = "boolean default true")
    private boolean accountNonLocked;


    @Column(columnDefinition = "boolean default true")
    private boolean credentialsNonExpired;


    @Column(columnDefinition = "boolean default true")
    private boolean enabled;



    public AppUser(RegisterRequest request) {
        this.id=0;
        this.name=request.getName();
        this.surname=request.getSurname();
        this.email=request.getEmail();
        this.password=request.getPassword();
        this.phoneNumber=request.getPhoneNumber();
        this.role=Role.USER;
        this.username=request.getUsername();
        this.enabled=true;
        this.accountNonExpired=true;
        this.credentialsNonExpired=true;
        this.accountNonLocked=true;
    }

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

    @Override
    public List<GrantedAuthority> getAuthorities() {
       // return Collections.list();
       List<GrantedAuthority> roleList =  new ArrayList();
       if (role==ADMIN){
           roleList.add(new SimpleGrantedAuthority(ADMIN.name()));
       }else{
           roleList.add(new SimpleGrantedAuthority(USER.name()));


       }


       return roleList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
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
