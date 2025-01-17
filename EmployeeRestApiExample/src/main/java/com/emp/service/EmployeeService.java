package com.emp.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.emp.entity.Employee;

@Service
public interface EmployeeService {

	public String deleteEmployee(Integer id);

	public Employee updateEmployeeById(Employee employee, Integer id);

	public List<Employee> getAllEmployeeById(Long length);

	public String addEmployee(Employee employee);

	public Employee getEmployeeById(Integer id);

	public Employee updateEmployeeByfield(Map<String, Object> fields, Integer id);

	

}
