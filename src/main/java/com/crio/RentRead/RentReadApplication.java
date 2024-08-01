package com.crio.RentRead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.crio.RentRead.Services.AuthService;

@SpringBootApplication
public class RentReadApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentReadApplication.class, args);
	}

	

	

}
