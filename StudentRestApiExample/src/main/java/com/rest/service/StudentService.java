package com.rest.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.rest.entity.Student;
@Service
public interface StudentService {
	
	public String addStudent(Student student);

	public Student getStudentById(Integer id);

	List<Student> getAllStudentById(Long length);

	Student updateStudent(Student student, Integer id);

	Student updateStudentByfield(Map<String, Object> fields, Integer id);
	
	public boolean deleteStudentByid(Integer id);

	
	
}
