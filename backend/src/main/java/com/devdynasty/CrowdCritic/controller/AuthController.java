package com.devdynasty.CrowdCritic.controller;

import com.devdynasty.CrowdCritic.model.AuthenticationRequest;
import com.devdynasty.CrowdCritic.model.AuthenticationResponse;
import com.devdynasty.CrowdCritic.model.RegisterRequest;
import com.devdynasty.CrowdCritic.service.AuthenticationService;
import com.devdynasty.CrowdCritic.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthenticationService authenticationService;

    private final TokenService tokenService;


    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
    public AuthController(AuthenticationService authenticationService, TokenService tokenService) {
        this.authenticationService = authenticationService;
        this.tokenService = tokenService;
    }



    @PostMapping("api/login")
    public ResponseEntity<AuthenticationResponse> token(@RequestBody AuthenticationRequest authenticationRequest){


            return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));

        }


    @PostMapping("api/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }




    }




