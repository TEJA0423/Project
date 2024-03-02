package com.time;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.time.repository.ProductRepository;
import com.time.repository.Product;

@SpringBootApplication
public class TimeStampingDjpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cntx = SpringApplication.run(TimeStampingDjpaApplication.class, args);
		ProductRepository pr = cntx.getBean(ProductRepository.class);

		Product p = new Product();
		p.setPid(101);
		p.setPpname("HP");
		p.setPp(55000.00);
		
		Product p1 = new Product();
		p1.setPid(102);
		p1.setPpname("DELL");
		p1.setPp(60000.00);

		pr.saveAll(Arrays.asList(p,p1));
		
		
			
		}
		
	}


