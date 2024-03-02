package com.emp.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.emp.entity.Employee;
import com.emp.repository.EmployeeRepository;


@Service
public class EmployeeServiceImp implements EmployeeService{
	@Autowired
	  public EmployeeRepository emprepo;
		@Override
		public String addEmployee(Employee employee) {
			Employee emp = emprepo.save(employee);
			if (emp.getId() != null) {
				return "Employee Id created";
			} else {
				return "Employee Id not created";
			}
		}

		@Override
		public Employee getEmployeeById(Integer id) {
			return emprepo.findById(id).orElseThrow(() -> new IllegalAccessError("Employee Record not created"));
		}

		@Override
		public List<Employee> getAllEmployeeById(Long length) {
			
			return emprepo.findAll();
		}

		@Override
		public Employee updateEmployeeById(Employee employee, Integer id) {
			Employee empl = emprepo.findById(id).get();
			empl.setName(employee.getName());
			empl.setYear(employee.getYear());
			empl.setGender(employee.getGender());
			return emprepo.save(empl);		
		}
	
		@Override
		public String deleteEmployee(Integer id) {
			emprepo.deleteById(id);
			return "Employeed deleted Successfully";
			
		}

		@Override
		public Employee updateEmployeeByfield(Map<String, Object> fields, Integer id) {
			Optional<Employee> existingstudent = emprepo.findById(id);
			if (existingstudent.isPresent()) {
				fields.forEach((key, value) -> {
					Field field = ReflectionUtils.findRequiredField(Employee.class, key);
					field.setAccessible(true);
					ReflectionUtils.setField(field, existingstudent, value);
				});

				return emprepo.save(existingstudent.get());
			}
			
			return null;
		}


}
