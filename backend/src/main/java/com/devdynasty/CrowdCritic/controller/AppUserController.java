package com.devdynasty.CrowdCritic.controller;

import com.devdynasty.CrowdCritic.dto.UserDto;
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
@CrossOrigin
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllAppUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.
                        appUserService.
                        getAllAppUsers()
                );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.
                        appUserService
                        .getAppUserById(id)
                );
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDto> getByUsername(@PathVariable String username) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this
                        .appUserService
                        .getAppUserByUsername(username)
                );

    }


}
