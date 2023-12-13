package com.rabbit.demorestfulapi.controller;


import com.rabbit.demorestfulapi.dto.DepartmentRequestDTO;
import com.rabbit.demorestfulapi.dto.DepartmentResponseDTO;
import com.rabbit.demorestfulapi.entities.Department;
import com.rabbit.demorestfulapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
    @Autowired
    DepartmentRepository repository;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
    public List<DepartmentResponseDTO> getDepartmentsList(){
        try{
            return repository.findAll().stream().map(DepartmentResponseDTO::new).toList();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
    public DepartmentResponseDTO getDepartmentById(@PathVariable Long id) {
        try {
            return new DepartmentResponseDTO(repository.findById(id).get());
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
    public DepartmentResponseDTO postDepartment(@RequestBody DepartmentRequestDTO departmentRequestDTO){
        try{
            Department department = new Department(departmentRequestDTO);
            repository.save(department);
            return new DepartmentResponseDTO(department);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
    public String deleteDepartment(@PathVariable Long id){
        try{
            repository.deleteById(id);
            return "deleted";
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
