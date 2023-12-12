package com.rabbit.demorestfulapi.dto;

import com.rabbit.demorestfulapi.entities.Department;
import com.rabbit.demorestfulapi.entities.Employee;

public record EmployeeResponseDTO(Long id, String peopleName, String email, Department department) {
	public EmployeeResponseDTO(Employee employee) {
		this(employee.getId(), employee.getEmployeeName(), employee.getEmail(), employee.getDepartment());
	}
}
