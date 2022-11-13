package com.main.entityformatting;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EntityformattingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntityformattingApplication.class, args);
		System.out.println("welcome to boot");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
