package com.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Data
@Table(name="Stu_tbl")
@AllArgsConstructor
public class Student {
	@Id
	private Integer Id;
	
	private String StumailId;
	
	private String Stuname;
	
	public Student() {

	}

	
}
