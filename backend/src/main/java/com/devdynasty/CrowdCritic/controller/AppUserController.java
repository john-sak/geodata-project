package com.devdynasty.CrowdCritic.controller;

import com.devdynasty.CrowdCritic.model.AppUser;
import com.devdynasty.CrowdCritic.service.AppUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping
    public ResponseEntity<String> createAppUser(@Valid @RequestBody AppUser appUser){

        var newappUser= Optional.of(this.appUserService.createAppUser(appUser));

       if (newappUser.isEmpty())
           return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("AppUser Not Created");

        return ResponseEntity.status(HttpStatus.CREATED).body("AppUser Created");

    }

}
