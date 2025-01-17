package com.teja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.teja.service.UserService;

@SpringBootApplication
public class ImageAddDbdjpaApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(ImageAddDbdjpaApplication.class, args);
		UserService us = context.getBean(UserService.class);
		us.saveUser();
	}

}

