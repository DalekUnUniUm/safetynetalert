package com.openclassrooms.safetynetalert;

import com.openclassrooms.safetynetalert.service.CheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
class SafetynetalertApplication implements CommandLineRunner {
	@Autowired
	private CheckerService checkerService;
	public static void main(String[] args) {
		SpringApplication.run(SafetynetalertApplication.class, args);
	}

	@Override
	public void run(String ...args) {
		System.out.println("-------------------------------------------");
		System.out.println("WELCOME TO SAFETY NET ALERT API VERSION 0.8");
		System.out.println("-------------------------------------------");
		checkerService.checkingLoadDataJSon();
	}

}
