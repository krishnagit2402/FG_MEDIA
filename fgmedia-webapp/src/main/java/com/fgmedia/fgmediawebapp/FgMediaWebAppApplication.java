package com.fgmedia.fgmediawebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FgMediaWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FgMediaWebAppApplication.class, args);
	}

}
