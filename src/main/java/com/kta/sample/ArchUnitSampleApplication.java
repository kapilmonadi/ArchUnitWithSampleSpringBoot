package com.kta.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.resilience.annotation.EnableResilientMethods;

@SpringBootApplication
@EnableResilientMethods
public class ArchUnitSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArchUnitSampleApplication.class, args);
	}

}
