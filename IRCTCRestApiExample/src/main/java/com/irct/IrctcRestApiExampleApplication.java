package com.irct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.irct.repository.IRCTCRepository;

@SpringBootApplication
public class IrctcRestApiExampleApplication {

	public static void main(String[] args) {
		 ConfigurableApplicationContext context = SpringApplication.run(IrctcRestApiExampleApplication.class, args);
		
		 IRCTCRepository irctcrepo = context.getBean(IRCTCRepository.class);
	}

}
