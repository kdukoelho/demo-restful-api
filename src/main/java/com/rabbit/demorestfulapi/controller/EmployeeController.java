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

	@PostMapping
	public EmployeeResponseDTO create(@RequestBody EmployeeRequestDTO employeeRequestDTO){
		try {
			Employee employee = new Employee(employeeRequestDTO);
			repository.save(employee);
			return new EmployeeResponseDTO(employee);
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@PutMapping("/{id}")
	public EmployeeResponseDTO update(@RequestBody EmployeeRequestDTO employeeRequestDTO, @PathVariable Long id){
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

	@GetMapping
	public List<EmployeeResponseDTO> getEmployeesList() {
		try {
			return repository.findAll().stream().map(EmployeeResponseDTO::new).toList();
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}

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
