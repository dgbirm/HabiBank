package com.habibank;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HabiBankApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(HabiBankApplication.class);
		Properties props = new Properties();
		props.setProperty("spring.resources.static-locations",
				"classpath:/../web-app/public/");
		app.run(args);
	}
	

}
