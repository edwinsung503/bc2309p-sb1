package com.vtxlab.bootcampbeanconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication = @ComponentScan + @SpringBootConfiguration + @EnableAutoConfiguration 

@SpringBootApplication
public class BootcampBeanConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampBeanConfigApplication.class, args);
	}

}
