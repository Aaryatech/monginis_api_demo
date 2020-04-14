package com.ats.webapi;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication(scanBasePackages={"com.ats.webapi"})
@EnableScheduling
public class MonginisWebApiApplication {

	
	public static void main(String[] args) {
		
		SpringApplication.run(MonginisWebApiApplication.class, args);
	}
	
}
