package com.rabbit.demorestfulapi.controller;


import com.rabbit.demorestfulapi.dto.DepartmentResponseDTO;
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
    public DepartmentResponseDTO getDepartmentById(@PathVariable Long id){
        return new DepartmentResponseDTO(repository.findById(id).get());
    }

}
