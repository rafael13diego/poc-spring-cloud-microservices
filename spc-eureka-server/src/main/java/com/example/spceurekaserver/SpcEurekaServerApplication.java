package com.example.spceurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpcEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpcEurekaServerApplication.class, args);
	}

}