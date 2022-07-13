package com.ironhack.starproxyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StarProxyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarProxyServiceApplication.class, args);
	}

}
