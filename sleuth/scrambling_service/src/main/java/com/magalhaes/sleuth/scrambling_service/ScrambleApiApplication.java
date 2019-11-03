package com.magalhaes.sleuth.scrambling_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ScrambleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScrambleApiApplication.class, args);
	}

}
