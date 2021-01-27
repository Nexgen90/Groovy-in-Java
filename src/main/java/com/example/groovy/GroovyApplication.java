package com.example.groovy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class GroovyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroovyApplication.class, args);
	}

}
