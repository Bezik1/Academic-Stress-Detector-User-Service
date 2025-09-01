package com.userservice.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

}

// brew services start postgresql
// psql
// export DB_URL={DB_URL}
// export DB_USERNAME={DB_USERNAME}
// export DB_PASSWORD={DB_PASSWORD}
// ./mvnw spring-boot:run