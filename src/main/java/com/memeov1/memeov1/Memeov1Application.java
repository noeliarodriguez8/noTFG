package com.memeov1.memeov1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Memeov1Application {

	public static void main(String[] args) {
		SpringApplication.run(Memeov1Application.class, args);
	}

}
