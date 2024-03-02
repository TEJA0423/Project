package com.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.emp.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeRestApiExampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cntx = SpringApplication.run(EmployeeRestApiExampleApplication.class, args);
		EmployeeRepository er = cntx.getBean(EmployeeRepository.class);
	}

}
