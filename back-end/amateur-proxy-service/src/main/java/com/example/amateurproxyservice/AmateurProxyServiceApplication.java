package com.example.amateurproxyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AmateurProxyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmateurProxyServiceApplication.class, args);
	}

}
