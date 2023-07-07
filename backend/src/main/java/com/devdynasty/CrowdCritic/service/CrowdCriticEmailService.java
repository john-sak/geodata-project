package com.devdynasty.CrowdCritic.service;

import com.devdynasty.CrowdCritic.model.AppUser;
import com.devdynasty.CrowdCritic.repository.AppUserRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrowdCriticEmailService  {




    private final JavaMailSender emailSender;

    private final AppUserService appUserService;

    public CrowdCriticEmailService(JavaMailSender emailSender, AppUserService appUserService) {
        this.emailSender = emailSender;
        this.appUserService = appUserService;
    }

    public void sendSimpleMessage(String to, String subject, String text) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("crowdcritic8@gmail.com");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
        }


    public void sendSimpleMessagToMultipleUsers(List<AppUser> users){

        String message= "Έχουν προστεθεί καινούργια σημεία ενδιαφέροντος";

        users.stream().map(
                user -> user.getEmail()
        ).forEach(
                userMail -> sendSimpleMessage(userMail,"Ενημέρωση",message)
        );



    }

    }



