package com.time;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.time.repository.AccountRepository;
import com.time.service.AccountService;

@SpringBootApplication
public class CompositePrimeryDjpa1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext cntxcomposite = SpringApplication.run(CompositePrimeryDjpa1Application.class, args);

		AccountService accountService = cntxcomposite.getBean(AccountService.class);
		accountService.saveAccData();
		accountService.getDataUsingPK();

		cntxcomposite.close();
	}

}
