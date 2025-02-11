package com.group.ecommerce_backend_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class EcommerceBackendSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceBackendSpringbootApplication.class, args);
		System.out.println("Hello, This is SpringBoot Backend");
	}

}
