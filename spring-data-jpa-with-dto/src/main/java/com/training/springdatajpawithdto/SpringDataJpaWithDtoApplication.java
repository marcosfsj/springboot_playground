package com.training.springdatajpawithdto;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaWithDtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaWithDtoApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

}
