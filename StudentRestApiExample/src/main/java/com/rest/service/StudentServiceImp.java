package com.rest.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.rest.entity.Student;
import com.rest.repository.StudentRepository;
@Service

public class StudentServiceImp implements StudentService {
	@Autowired
	public StudentRepository sturep;

	@Override
	public String addStudent(Student student) {
		Student stu = sturep.save(student);
		if (stu.getId() != null) {
			return "Student created";
		} else {
			return "Student not created";
		}
	}

	@Override
	public Student getStudentById(Integer id) {

		return sturep.findById(id).orElseThrow(() -> new IllegalAccessError("Student Record not created"));
	}

	@Override
	public List<Student> getAllStudentById(Long length) {

		return sturep.findAll();
	}

	@Override
	public Student updateStudent(Student student, Integer id) {
		Student sts1 = sturep.findById(id).get();
		sts1.setStuname(student.getStuname());
		sts1.setStumailId(student.getStumailId());
		return sturep.save(sts1);
	}

	@Override
	public Student updateStudentByfield(Map<String, Object> fields, Integer id) {
		Optional<Student> existingstudent = sturep.findById(id);
		if (existingstudent.isPresent()) {
			fields.forEach((key, value) -> {
				Field field = ReflectionUtils.findRequiredField(Student.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, existingstudent, value);
			});

			return sturep.save(existingstudent.get());
		}
		return null;
	}

	@Override
	public boolean deleteStudentByid(Integer id) {
		boolean status = false;
		try {
		sturep.deleteById(id);
		status = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}


}
