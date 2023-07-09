package com.devdynasty.CrowdCritic.service;

import com.devdynasty.CrowdCritic.model.AppUser;
import com.devdynasty.CrowdCritic.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrowdCriticEmailService {


    private final JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String email;
    private final AppUserService appUserService;

    public CrowdCriticEmailService(JavaMailSender emailSender, AppUserService appUserService) {
        this.emailSender = emailSender;
        this.appUserService = appUserService;
    }

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }


    public void sendSimpleMessagToMultipleUsers(List<AppUser> users) {

        String message = "Έχουν προστεθεί καινούργια σημεία ενδιαφέροντος";

        users.stream().map(
                user -> user.getEmail()
        ).forEach(
                userMail -> sendSimpleMessage(userMail, "Ενημέρωση", message)
        );


    }


    public void sendSimpleMessagToMultipleUsersByEmail (List<String> emails) {

        String message = "Έχουν προστεθεί καινούργια σημεία ενδιαφέροντος";

        emails.stream().forEach(
                email -> sendSimpleMessage(email, "Ενημέρωση", message)
        );


    }



}

