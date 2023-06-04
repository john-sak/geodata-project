package com.devdynasty.CrowdCritic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
public class ErrorModel {

        private final HttpStatus httpStatus;

        private final LocalDateTime timestamp;

        private final String message;

        private final String details;


    }

