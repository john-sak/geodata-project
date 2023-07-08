package com.devdynasty.CrowdCritic.service;

import com.devdynasty.CrowdCritic.dto.UserDto;
import com.devdynasty.CrowdCritic.exception.UserEmailExistsException;
import com.devdynasty.CrowdCritic.exception.UsernameExistsException;
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

    private final AppUserService appUserService;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;


    public AuthenticationService(AppUserRepository appUserRepository,
                                 AppUserService appUserService, TokenService tokenService,
                                 PasswordEncoder passwordEncoder,
                                 AuthenticationManager authenticationManager,
                                 TokenRepository tokenRepository){
        this.appUserService = appUserService;
        this.tokenService=tokenService;
        this.authenticationManager=authenticationManager;
        this.passwordEncoder=passwordEncoder;
        this.appUserRepository=appUserRepository;
        this.tokenRepository = tokenRepository;
    }

    public AuthenticationResponse register(RegisterRequest request) throws UsernameExistsException, UserEmailExistsException {

        var password = passwordEncoder.encode(request.getPassword());
        request.setPassword(password);
        Optional<AppUser> optionalAppUser = appUserRepository.findAppUsersByUsername(request.getUsername());
       if  (optionalAppUser.isPresent()) throw new UsernameExistsException("USER_NAME_EXISTS");

        if ( (appUserRepository.findAppUserByEmail(request.getEmail())).isPresent())
            throw new UserEmailExistsException("USER_EMAIL_EXISTS");


        var user = new AppUser(request);
        user=this.appUserRepository.save(user);



        Token token = new Token(0,
                tokenService.generateToken(user),
                tokenService.generateRefreshToken(user),
                false,user);
        this.tokenService.storeToken(token);
        return new AuthenticationResponse(new UserDto(user),token.getToken(),token.getRefreshToken());
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

        return new AuthenticationResponse(new UserDto(user),newToken.getToken(), newToken.getRefreshToken());
    }


    public AuthenticationResponse refresh(RefreshRequest request) throws IllegalAccessException {


        String username =  tokenService.extractUsername(request.getRefreshToken());

        Token newToken;
        String refreshToken = request.getRefreshToken();

        if (!tokenService.isTokenValid(refreshToken, appUserService.loadUserByUsername(username))){

              throw new IllegalAccessException("NOT VALID REFRESH TOKEN ");

        }


        var user = appUserRepository.findAppUsersByUsername(tokenService.extractUsername(refreshToken)).orElseThrow();

        newToken = new Token(null,
                tokenService.generateToken(user),
                tokenService.generateRefreshToken(user),
                false,
                user);


        Optional<Token> prevToken = Optional.ofNullable(tokenRepository.findByUserIdAndExpiredIsFalse(user.getId()).orElse(null));

        prevToken.ifPresent(token -> tokenService.expireToken(token.getId()));

        tokenRepository.save(newToken);



        return new AuthenticationResponse(new UserDto(user),newToken.getToken(), newToken.getRefreshToken());




    }





}
