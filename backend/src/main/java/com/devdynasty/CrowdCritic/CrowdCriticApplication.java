package com.devdynasty.CrowdCritic;

import com.devdynasty.CrowdCritic.model.RegisterRequest;
import com.devdynasty.CrowdCritic.service.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import static com.devdynasty.CrowdCritic.model.Role.ADMIN;

//TODO ids annotation type should ne matching the database(id , default etc)

@SpringBootApplication
public class CrowdCriticApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrowdCriticApplication.class, args);
	}

}
