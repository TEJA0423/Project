package com.emp.controller;

import java.util.List;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entity.Employee;
import com.emp.service.EmployeeService;


@RestController
@RequestMapping("/Employee/")
public class EmployeeController {
	@Autowired
	private EmployeeService empservice;
	@PostMapping("/add")
	public ResponseEntity<String> saveEmployeeintoDB(@RequestBody Employee employee){
		String addEmployee =empservice.addEmployee(employee);
		return new ResponseEntity<>(addEmployee,HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id){
		Employee employeebyId =empservice.getEmployeeById(id);
		return new ResponseEntity<>(employeebyId,HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployeeById(@RequestParam(name="length", required = false)Long length){
		List<Employee>allemp =empservice.getAllEmployeeById(length);
		if(length == null) {
			return new ResponseEntity<>(allemp.stream().limit(10).collect(Collectors.toList()),HttpStatus.OK);	
		}else {
			return new ResponseEntity<>(allemp.stream().limit(length).collect(Collectors.toList()),HttpStatus.OK);	
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee>updateEmpolyee(@RequestBody Employee employee, @PathVariable Integer id){
		Employee updateEmpolyee =empservice.updateEmployeeById(employee,id);
		return new ResponseEntity<>(updateEmpolyee,HttpStatus.ACCEPTED);
	}
	@PatchMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployeeByfield(@RequestBody Map<String, Object> fields,@PathVariable Integer id){
		Employee updateemployeebyfield =empservice.updateEmployeeByfield(fields, id);
		return new ResponseEntity<>(updateemployeebyfield,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Object> deleteIRCTC(@PathVariable Integer id){
		String msg = empservice.deleteEmployee(id);
		
		return new ResponseEntity<>(msg,HttpStatus.OK);

	}


}
