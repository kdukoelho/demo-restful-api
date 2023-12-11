package com.rabbit.demorestfulapi.controller;

import java.util.List;

import com.rabbit.demorestfulapi.dto.PeopleRequestDTO;
import com.rabbit.demorestfulapi.entities.People;
import org.springframework.beans.factory.annotation.Autowired;

import com.rabbit.demorestfulapi.dto.PeopleResponseDTO;
import com.rabbit.demorestfulapi.repository.PeopleRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/peoples")
public class PeopleController {

	@Autowired
	private PeopleRepository repository;

	@CrossOrigin(origins = "http://localhost:8080", allowedHeaders =  "*")
	@PostMapping
	public void postPeople(@RequestBody PeopleRequestDTO peopleRequestDTO){
		People people = new People(peopleRequestDTO);
		repository.save(people);
	}

	@CrossOrigin(origins = "http://localhost:8080", allowedHeaders =  "*")
	@GetMapping
	public List<PeopleResponseDTO> getPeoplesList() {
		List<PeopleResponseDTO> productList = repository.findAll().stream().map(PeopleResponseDTO::new).toList();
		return productList;
	}

	@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
	@GetMapping("/{id}")
	public PeopleResponseDTO getPeopleById(@PathVariable Long id){
		People people = repository.findById(id).get();
		return new PeopleResponseDTO(people);
	}

	@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
	@DeleteMapping("/{id}")
	public void deletePeopleById(@PathVariable long id){
		repository.deleteById(id);
	}
}
