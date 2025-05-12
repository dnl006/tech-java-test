package com.java.authentication.api;

import com.java.authentication.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthenticationApiApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public AuthenticationApiApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApiApplication.class, args);
	}

	@Override
	public void run(String... args) {
		userService.saveDefaultUser();
	}

}
