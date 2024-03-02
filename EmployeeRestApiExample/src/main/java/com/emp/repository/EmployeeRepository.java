package com.emp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entity.Employee;

import jakarta.persistence.Entity;
import lombok.Data;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{



}
