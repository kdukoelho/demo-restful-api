package com.rabbit.demorestfulapi.controller;

import java.net.URI;
import java.util.List;

import com.rabbit.demorestfulapi.dto.EmployeeRequestDTO;
import com.rabbit.demorestfulapi.entities.Employee;
import com.rabbit.demorestfulapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import com.rabbit.demorestfulapi.dto.EmployeeResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping
	public ResponseEntity<List<EmployeeResponseDTO>> findAll() {
		try {
			List<EmployeeResponseDTO> departmentList = service.findAll();
			return ResponseEntity.ok().body(departmentList);
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> findById(@PathVariable Long id){
		try {
			EmployeeResponseDTO employeeResponseDTO = service.findById(id);
			return ResponseEntity.ok().body(employeeResponseDTO);
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}


	@PostMapping
	public ResponseEntity<Void> create(@RequestBody EmployeeRequestDTO employeeRequestDTO){
		try {
			EmployeeResponseDTO employeeResponseDTO = service.create(employeeRequestDTO);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employeeResponseDTO.id()).toUri();
			return ResponseEntity.created(uri).build();
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody EmployeeRequestDTO employeeRequestDTO, @PathVariable Long id){
		try {
			service.update(employeeRequestDTO, id);
			return ResponseEntity.noContent().build();
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable long id) {
		try {
			service.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
