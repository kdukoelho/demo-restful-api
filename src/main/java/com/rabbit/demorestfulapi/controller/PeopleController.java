package com.rabbit.demorestfulapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.demorestfulapi.dto.PeopleResponseDTO;
import com.rabbit.demorestfulapi.repository.PeopleRepository;

@RestController
@RequestMapping(value = "/peoples")
public class PeopleController {
	
	@Autowired
	private PeopleRepository repository;
	@GetMapping
	public List<PeopleResponseDTO> getPeoples() {
		
		List<PeopleResponseDTO> productList = repository.findAll().stream().map(PeopleResponseDTO::new);
		
		return productList;
	}
}
