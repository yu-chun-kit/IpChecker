package com.example.storeIp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@Configuration
@SpringBootApplication
public class StoreIpApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreIpApplication.class, args);
	}

}
