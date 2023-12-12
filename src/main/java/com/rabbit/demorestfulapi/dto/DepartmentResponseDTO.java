package com.rabbit.demorestfulapi.dto;

import com.rabbit.demorestfulapi.entities.Department;

public record DepartmentResponseDTO(Long id, String name) {
    public DepartmentResponseDTO(Department department){
        this(department.getId(), department.getDepName());
    }
}
