package com.cqsr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QueryKafkaApiApplication {

	public static void main(String[] args) {

		System.out.println("Test");
		SpringApplication.run(QueryKafkaApiApplication.class, args);
	}

}
