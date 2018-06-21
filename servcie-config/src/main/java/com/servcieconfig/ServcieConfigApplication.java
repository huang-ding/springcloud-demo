package com.servcieconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ServcieConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServcieConfigApplication.class, args);
	}
}
