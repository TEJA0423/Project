package com.rest;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.rest.repository.StudentRepository;
import com.rest.entity.Student;

@SpringBootApplication
public class StudentRestApiExampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cntx = SpringApplication.run(StudentRestApiExampleApplication.class, args);
		StudentRepository sr = cntx.getBean(StudentRepository.class);
		
		Student s= new Student();
		s.setId(1);
		s.setStuname("Gayathri");
		s.setStumailId("gayathri@gamil.com");
		
		Student s1= new Student();
		s1.setId(2);
		s1.setStuname("Uma");
		s1.setStumailId("uma@gamil.com");
		
		Student s2= new Student();
		s2.setId(3);
		s2.setStuname("Mohan");
		s2.setStumailId("mohan@gamil.com");
		
		Student s3= new Student();
		s3.setId(4);
		s3.setStuname("Naidu");
		s3.setStumailId("naidu@gamil.com");
		
		sr.saveAll(Arrays.asList(s,s1,s2,s3));
	}

}
	
