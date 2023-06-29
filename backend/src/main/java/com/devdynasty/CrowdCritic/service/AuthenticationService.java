package com.devdynasty.CrowdCritic.service;

import com.devdynasty.CrowdCritic.model.*;

import com.devdynasty.CrowdCritic.repository.AppUserRepository;
import com.devdynasty.CrowdCritic.repository.TokenRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class AuthenticationService {

    private final AppUserRepository appUserRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;


    public AuthenticationService(AppUserRepository appUserRepository,
                                 TokenService tokenService,
                                 PasswordEncoder passwordEncoder,
                                 AuthenticationManager authenticationManager,
                                 TokenRepository tokenRepository){
        this.tokenService=tokenService;
        this.authenticationManager=authenticationManager;
        this.passwordEncoder=passwordEncoder;
        this.appUserRepository=appUserRepository;
        this.tokenRepository = tokenRepository;
    }

    public AuthenticationResponse register(RegisterRequest request) {

        var password = passwordEncoder.encode(request.getPassword());
        request.setPassword(password);
        var user = new AppUser(request);
        user=this.appUserRepository.save(user);



        Token token = new Token(0,
                tokenService.generateToken(user),
                tokenService.generateRefreshToken(user),
                false,user);
        this.tokenService.storeToken(token);
        return new AuthenticationResponse(token.getToken(),token.getRefreshToken());
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var user = appUserRepository.findAppUsersByUsername(authentication.getName())
                .orElseThrow();



        Token newToken = new Token(null,
                tokenService.generateToken(user),
                tokenService.generateRefreshToken(user),
                false,
                user);


        Optional<Token> prevToken = Optional.ofNullable(tokenRepository.findByUserIdAndExpiredIsFalse(user.getId()).orElse(null));

        prevToken.ifPresent(token -> tokenService.expireToken(token.getId()));

        tokenRepository.save(newToken);

        return new AuthenticationResponse(newToken.getToken(), newToken.getRefreshToken());
    }


}
