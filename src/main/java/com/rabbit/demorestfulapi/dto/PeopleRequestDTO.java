package com.rabbit.demorestfulapi.dto;

import com.rabbit.demorestfulapi.entities.Department;

public record PeopleRequestDTO(String peopleName, String email, Department department) {
}
