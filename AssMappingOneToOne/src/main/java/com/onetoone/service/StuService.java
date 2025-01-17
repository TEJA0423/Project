package com.onetoone.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetoone.entity.Address;
import com.onetoone.entity.Student;
import com.onetoone.repository.AddressRepository;
import com.onetoone.repository.StudentRepository;

@Service
public class StuService {
	private StudentRepository sturep;
	private AddressRepository adrep;
	@Autowired
	public StuService(StudentRepository sturep, AddressRepository adrep) {
		super();
		this.sturep = sturep;
		this.adrep = adrep;
	}
	public void savedata() {
		Student student=new Student();
		student.setStuname("Shivansh lalam");
		student.setStumailid("shivansh@gmail.com");
	
		Student student1=new Student();
		student1.setStuname("Srihan Lalam");
		student1.setStumailid("Srihan@gmail.com");
		sturep.saveAll(Arrays.asList(student1,student));
		Address address= new Address();
		address.setCity("hyd");
		address.setState("ts");
		address.setCountry("india");
		address.setStu(student);
		Address address1= new Address();
		address1.setCity("vizag");
		address1.setState("ap");
		address1.setCountry("india");
		address1.setStu(student1);
		List<Address>ad=Arrays.asList(address,address1);
		student.setStuadress(ad);
		adrep.saveAll(Arrays.asList(address,address1));
	}
	
	
}
