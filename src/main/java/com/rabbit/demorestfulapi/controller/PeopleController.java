package com.rabbit.demorestfulapi.controller;

import java.util.List;

import com.rabbit.demorestfulapi.dto.PeopleRequestDTO;
import com.rabbit.demorestfulapi.entities.People;
import org.springframework.beans.factory.annotation.Autowired;

import com.rabbit.demorestfulapi.dto.PeopleResponseDTO;
import com.rabbit.demorestfulapi.repository.PeopleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/peoples")
public class PeopleController {
	
	@Autowired
	private PeopleRepository repository;
	@PostMapping
	public void postPeople(@RequestBody PeopleRequestDTO peopleRequestDTO){
		People people = new People(peopleRequestDTO);
		repository.save(people);
	}

	@GetMapping
	public List<PeopleResponseDTO> getPeoples() {

		List<PeopleResponseDTO> productList = repository.findAll().stream().map(PeopleResponseDTO::new).toList();
		
		return productList;
	}
}
