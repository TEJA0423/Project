package com.teja;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.teja.repository.Address;
import com.teja.repository.EmployeeRepository;
import com.teja.repository.Employee;

@SpringBootApplication
public class AssociationMapping {

	public static void main(String[] args) {
		ConfigurableApplicationContext cntx = SpringApplication.run(AssociationMapping.class, args);
		EmployeeRepository er = cntx.getBean(EmployeeRepository.class);

		Employee e = new Employee();
		// e.setEmpId(101);
		e.setEmpName("Ram");
		e.setEmpSalary(8.2);

		Address a = new Address();
		// a.setId(1);
		a.setState("AP");
		a.setCity("VIZAG");
		a.setCountry("BHARATH");
		a.setEmp(e);

		Address a1 = new Address();
	//	a1.setId(2);
		a1.setState("AP");
		a1.setCity("HYD");
		a1.setCountry("BHARATH");
		a1.setEmp(e);

		List<Address> list = Arrays.asList(a, a1);
		e.setEmpAddress(list);
		er.save(e);

	}

}
