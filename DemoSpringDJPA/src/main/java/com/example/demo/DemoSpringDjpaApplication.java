package com.example.demo;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.repository.StudentRepository;

import com.example.demo.repository.Student;

@SpringBootApplication
public class DemoSpringDjpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cntx = SpringApplication.run(DemoSpringDjpaApplication.class, args);
		StudentRepository sr = cntx.getBean(StudentRepository.class);
		

//		Student s1= new Student(1, "Ramu", 30, "Vizag");
//		Student s2= new Student(2, "Teju", 24, "Hyd");
//		Student s3= new Student(3, "Ammulu", 21, "Eluru");
//		Student s4= new Student(4, "Renu", 35, "Tpd");
//		Student s5= new Student(5, "Pandu", 20, "Rajhmandri");
//		Student s6= new Student(6, "Raju", 32, "Hyd");
//		Student s7= new Student(7, "Githu", 27, "Vizag");
//		sr.saveAll(Arrays.asList(s1,s2,s3,s4,s5,s6,s7));
		
		Student s1 = new Student();
		s1.setId(1);
		s1.setName("Teju");
		s1.setAge(24);
		s1.setLocation("Eluru");
		Student s2 = new Student();
		s2.setId(2);
		s2.setName("Ramu");
		s2.setAge(30);
		s2.setLocation("vizag");
		Student s3 = new Student();
		s3.setId(3);
		s3.setName("Srihan");
		s3.setAge(15);
		s3.setLocation("Kanchrapalem");
		Student s4 = new Student();
		s4.setId(4);
		s4.setName("Gayathri");
		s4.setAge(26);
		s4.setLocation("Gajuwaka");
		Student s5 = new Student();
		s5.setId(5);
		s5.setName("Subhadra");
		s5.setAge(44);
		s5.setLocation("WestGodavari");
		sr.saveAll(Arrays.asList(s1,s2,s3,s4,s5));
		
//		Optional<Student> result = sr.findById(5);
//		if(result.isPresent()) {
//			System.out.println(result);
//		}
		
		

	}

}
