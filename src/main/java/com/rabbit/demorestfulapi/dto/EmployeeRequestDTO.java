package com.rabbit.demorestfulapi.dto;

import com.rabbit.demorestfulapi.entities.Department;

public record EmployeeRequestDTO(String employeeName, String email, Department department) {
}
