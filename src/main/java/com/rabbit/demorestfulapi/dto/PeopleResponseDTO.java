package com.rabbit.demorestfulapi.dto;

import com.rabbit.demorestfulapi.entities.Department;
import com.rabbit.demorestfulapi.entities.People;

public record PeopleResponseDTO(Long id, String peopleName, String email, Department department) {
	public PeopleResponseDTO(People people) {
		this(people.getId(), people.getPeopleName(), people.getEmail(), people.getDepartment());
	}
}
