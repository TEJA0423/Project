package com.example.demo.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "COLLEGE_STUDENT")
@Data
@AllArgsConstructor
public class Student {
	@Id
	@Column(name = "STUDENT-ID")
	private Integer id;
	@Column(name = "STUDENT-NAME")
	private String name;
	@Column(name = "STUDENT-AGE")
	private Integer age;
	@Column(name = "STUDENT-LOCATION")
	private String location;

	public Student() {

	}

}
