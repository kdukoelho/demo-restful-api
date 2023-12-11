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
		try {
			People people = new People(peopleRequestDTO);
			repository.save(people);
		} catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	@CrossOrigin(origins = "http://localhost:8080", allowedHeaders =  "*")
	@GetMapping
	public List<PeopleResponseDTO> getPeoplesList() {
		try {
			List<PeopleResponseDTO> productList = repository.findAll().stream().map(PeopleResponseDTO::new).toList();
			return productList;
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
	@GetMapping("/{id}")
	public PeopleResponseDTO getPeopleById(@PathVariable Long id){
		try {
			People people = repository.findById(id).get();
			return new PeopleResponseDTO(people);
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
	@DeleteMapping("/{id}")
	public void deletePeopleById(@PathVariable long id){
		try {
		repository.deleteById(id);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
