package com.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onetoone.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
