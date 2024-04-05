package com.example.CrudJPARest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class CrudJpaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudJpaRestApplication.class, args);
		System.out.println(SpringVersion.getVersion());
	}

}
