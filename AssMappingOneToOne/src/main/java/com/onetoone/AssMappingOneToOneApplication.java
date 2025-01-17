package com.onetoone;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.onetoone.service.StuService;

@SpringBootApplication
public class AssMappingOneToOneApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cntx = SpringApplication.run(AssMappingOneToOneApplication.class, args);
		StuService service = cntx.getBean(StuService.class);
		service.savedata();
	}

}
