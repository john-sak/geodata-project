package com.devdynasty.CrowdCritic.controller;

import com.devdynasty.CrowdCritic.model.AppUser;
import com.devdynasty.CrowdCritic.service.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    public ResponseEntity<List<AppUser>> getAllAppUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(this.appUserService.getAllAppUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.appUserService.getAppUserById(id));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<AppUser> getByUsername(@PathVariable String username) {
        return ResponseEntity.status(HttpStatus.OK).body(this.appUserService.getAppUserByUsername(username));

    }


}
