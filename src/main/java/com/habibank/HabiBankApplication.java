package com.habibank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HabiBankApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(HabiBankApplication.class);
		app.run(args);
	}
	
}
