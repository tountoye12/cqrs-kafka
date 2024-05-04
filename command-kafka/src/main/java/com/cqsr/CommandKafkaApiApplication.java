package com.cqsr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommandKafkaApiApplication {

	public static void main(String[] args) {
		System.out.println("Test");
		SpringApplication.run(CommandKafkaApiApplication.class, args);
	}

}
