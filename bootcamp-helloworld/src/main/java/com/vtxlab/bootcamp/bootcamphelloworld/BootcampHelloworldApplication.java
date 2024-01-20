package com.vtxlab.bootcamp.bootcamphelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootcampHelloworldApplication {

	public static void main(String[] args) { // JVM call main
		System.out.println("hello");
		SpringApplication.run(BootcampHelloworldApplication.class, args);
		//control c -> to kill the 
	}

}
