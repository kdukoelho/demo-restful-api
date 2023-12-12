package com.rabbit.demorestfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rabbit.demorestfulapi.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
