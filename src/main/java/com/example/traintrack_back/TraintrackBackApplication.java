package com.example.traintrack_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * Main app
 */
@SpringBootApplication
@Slf4j
public class TraintrackBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraintrackBackApplication.class, args);
		log.info("Swagger on http://localhost:8080/swagger-ui.html");

	}

}
