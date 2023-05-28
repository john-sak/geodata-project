package com.devdynasty.CrowdCritic;

import com.devdynasty.CrowdCritic.model.RegisterRequest;
import com.devdynasty.CrowdCritic.service.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import static com.devdynasty.CrowdCritic.model.Role.ADMIN;

@SpringBootApplication
public class CrowdCriticApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrowdCriticApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var kostas = RegisterRequest.builder()
					.name("kostas")
					.username("kagoris")
					.surname("agoris")
					.email("kostas@mail.com")
					.password("12345678")
					.phoneNumber("2109876543")
					.role(ADMIN)
					.build();
			var stefamos = RegisterRequest.builder()
					.name("stefanos")
					.username("svavoulas")
					.surname("vavoulas")
					.email("stefanos@mail.com")
					.password("12345678")
					.phoneNumber("2109876542")
					.role(ADMIN)
					.build();
			var nikos = RegisterRequest.builder()
					.name("nikos")
					.username("nmasouras")
					.surname("masouras")
					.email("nikos@mail.com")
					.password("12345678")
					.phoneNumber("2109876541")
					.role(ADMIN)
					.build();
			var dimitris = RegisterRequest.builder()
					.name("dimitris")
					.username("dmperos")
					.surname("mperos")
					.email("dimitris@mail.com")
					.password("12345678")
					.phoneNumber("2109876540")
					.role(ADMIN)
					.build();
			var ioannis = RegisterRequest.builder()
					.name("ioannis")
					.username("isakarelos")
					.surname("sakarelos")
					.email("ioannis@mail.com")
					.password("12345678")
					.phoneNumber("2109876549")
					.role(ADMIN)
					.build();
            service.register(kostas);
			service.register(stefamos);
			service.register(nikos);
			service.register(dimitris);
			service.register(ioannis);


		};
	}

}
