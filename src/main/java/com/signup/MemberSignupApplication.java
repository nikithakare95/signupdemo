package com.signup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableMongoRepositories(basePackages = { "com.signup.repository"})
@ComponentScan({"com.signup.service" ,"com.signup.controller","com.signup.model","com.signup.DTO"})
public class MemberSignupApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberSignupApplication.class, args);
	}

}
