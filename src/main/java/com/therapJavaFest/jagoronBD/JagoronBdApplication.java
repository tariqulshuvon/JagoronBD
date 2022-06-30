package com.therapJavaFest.jagoronBD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JagoronBdApplication {

	public static void main(String[] args) {
		SpringApplication.run(JagoronBdApplication.class, args);
	}

	void display() {
		System.out.println("started");
	}
}
