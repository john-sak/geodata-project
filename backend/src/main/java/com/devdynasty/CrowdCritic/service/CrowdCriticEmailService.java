package com.devdynasty.CrowdCritic.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CrowdCriticEmailService  {




    private final JavaMailSender emailSender;

    public CrowdCriticEmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(String to, String subject, String text) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("crowdcritic8@gmail.com");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
        }
    }



