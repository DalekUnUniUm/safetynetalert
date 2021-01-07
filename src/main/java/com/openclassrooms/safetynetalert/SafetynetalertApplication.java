package com.openclassrooms.safetynetalert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SafetynetalertApplication implements CommandLineRunner {

	@Autowired
	private LoadDataJSON loadDataJSON ;

	public static void main(String[] args) {
		SpringApplication.run(SafetynetalertApplication.class, args);
	}

	@Override
	public void run(String ...args) throws Exception{
		System.out.println("-------------------------------------------");
		System.out.println("WELCOME TO SAFETY NET ALERT API VERSION 0.3");
		System.out.println("-------------------------------------------");
	    System.out.println("Loading DataJson ...");
	    System.out.println("-----------------");
	    System.out.println("Load Persons");
		loadDataJSON.loadPersons();
        System.out.println("Load FireStations");
		loadDataJSON.loadFireStations();
        System.out.println("Load Medical Records");
		loadDataJSON.loadMedicalRecords();
        System.out.println("-----------------");
		System.out.println("Loading over");
	}

}
