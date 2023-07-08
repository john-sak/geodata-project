package com.devdynasty.CrowdCritic.controller;

import com.devdynasty.CrowdCritic.exception.UserEmailExistsException;
import com.devdynasty.CrowdCritic.exception.UsernameExistsException;
import com.devdynasty.CrowdCritic.model.AuthenticationRequest;
import com.devdynasty.CrowdCritic.model.AuthenticationResponse;
import com.devdynasty.CrowdCritic.model.RefreshRequest;
import com.devdynasty.CrowdCritic.model.RegisterRequest;
import com.devdynasty.CrowdCritic.service.AuthenticationService;
import com.devdynasty.CrowdCritic.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//TODO DEBUG updates tokens of different users
@RestController
@CrossOrigin
public class AuthController {
    private final AuthenticationService authenticationService;




    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }



    @PostMapping("api/login")
    public ResponseEntity<AuthenticationResponse> token(@RequestBody AuthenticationRequest authenticationRequest){


            return ResponseEntity
                    .ok(authenticationService
                            .authenticate(authenticationRequest)
                    );

        }


    @PostMapping("api/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) throws UsernameExistsException, UserEmailExistsException {
        return ResponseEntity
                .ok(authenticationService
                        .register(request)
                );
    }


        @PostMapping("api/refreshtoken")
    public ResponseEntity<AuthenticationResponse> refresh(
            @RequestBody RefreshRequest request
    ) throws IllegalAccessException {
        return ResponseEntity
                .ok(authenticationService
                        .refresh(request)
                );
    }




    }




