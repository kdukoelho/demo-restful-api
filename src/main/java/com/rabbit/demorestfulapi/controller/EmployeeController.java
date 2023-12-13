package com.rabbit.demorestfulapi.controller;

import java.util.List;

import com.rabbit.demorestfulapi.dto.EmployeeRequestDTO;
import com.rabbit.demorestfulapi.entities.Employee;

import org.springframework.beans.factory.annotation.Autowired;

import com.rabbit.demorestfulapi.dto.EmployeeResponseDTO;
import com.rabbit.demorestfulapi.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@CrossOrigin(origins = "http://localhost:8080", allowedHeaders =  "*")
	@PostMapping
	public EmployeeResponseDTO postEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
		try {
			Employee employee = new Employee(employeeRequestDTO);
			repository.save(employee);
			return new EmployeeResponseDTO(employee);
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
	@PostMapping("/{id}")
	public EmployeeResponseDTO updateEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO, @PathVariable Long id){
		try {
			Employee employee = new Employee(employeeRequestDTO);
			employee.setId(id);
			repository.save(employee);
			return new EmployeeResponseDTO(employee);
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}


	@CrossOrigin(origins = "http://localhost:8080", allowedHeaders =  "*")
	@GetMapping
	public List<EmployeeResponseDTO> getEmployeesList() {
		try {
			return repository.findAll().stream().map(EmployeeResponseDTO::new).toList();
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
	@GetMapping("/{id}")
	public EmployeeResponseDTO getEmployeeById(@PathVariable Long id){
		try {
			Employee employee = repository.findById(id).get();
			return new EmployeeResponseDTO(employee);
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable long id) {
		try {
			repository.deleteById(id);
			return "deleted";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
