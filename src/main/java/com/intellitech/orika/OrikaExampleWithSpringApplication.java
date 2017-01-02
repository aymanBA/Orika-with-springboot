package com.intellitech.orika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.intellitech.orika"})
public class OrikaExampleWithSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrikaExampleWithSpringApplication.class, args);
	}
}
