package com.springboot.crud.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.springboot.crud.springmvc"})
public class SpringbootkafkaprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootkafkaprojectApplication.class, args);
	}

}
