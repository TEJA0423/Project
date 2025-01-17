package com.rest.controller;

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

import com.rest.entity.Student;
import com.rest.service.StudentService;
@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService stuser;
	@PostMapping("/add")
	public ResponseEntity<String> saveStudentintoDB(@RequestBody Student student){
		String addStudent =stuser.addStudent(student);
		return new ResponseEntity<>(addStudent,HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Integer id){
		Student studentbyId =stuser.getStudentById(id);
		return new ResponseEntity<>(studentbyId,HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudentById(@RequestParam(name="length", required = false)Long length){
		List<Student>stulist =stuser.getAllStudentById(length);
		if(length==null) {
			return new ResponseEntity<>(stulist.stream().limit(10).collect(Collectors.toList()),HttpStatus.OK);	
		}else {
			return new ResponseEntity<>(stulist.stream().limit(length).collect(Collectors.toList()),HttpStatus.OK);	
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Student>pdateStudent(@RequestBody Student student, @PathVariable Integer id){
		Student updateStudent =stuser.updateStudent(student,id);
		return new ResponseEntity<>(updateStudent,HttpStatus.ACCEPTED);
	}
	@PatchMapping("/update/{id}")
	public ResponseEntity<Student> updateStudentByfield(@RequestBody Map<String, Object> fields,@PathVariable Integer id){
		Student updateStudentByfield =stuser.updateStudentByfield(fields, id);
		return new ResponseEntity<>(updateStudentByfield,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
		boolean isDeleted = stuser.deleteStudentByid(id);
		String msg="";
		if(isDeleted) {
			msg = "Student Deleted Sucessfully";
		}else {
			msg = "Student Delete Failed";
		}
		
		return new ResponseEntity<>(HttpStatus.OK);

	}


}
