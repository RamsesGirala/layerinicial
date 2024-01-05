package com.catedra.democatedra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemocatedraApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocatedraApplication.class, args);
		System.out.println("Funcionando en capas");
	}

}
