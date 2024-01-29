package com.rabbit.demorestfulapi.controller;


import com.rabbit.demorestfulapi.dto.DepartmentRequestDTO;
import com.rabbit.demorestfulapi.dto.DepartmentResponseDTO;
import com.rabbit.demorestfulapi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @GetMapping
    public ResponseEntity<List<DepartmentResponseDTO>> findAll() {
        try {
            List<DepartmentResponseDTO> departmentsList = service.findAll();
            return ResponseEntity.ok().body(departmentsList);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO> findById(@PathVariable Long id) {
        try {
            DepartmentResponseDTO departmentResponseDTO = service.findById(id);
            return ResponseEntity.ok().body(departmentResponseDTO);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody DepartmentRequestDTO departmentRequestDTO) {
        try {
            DepartmentResponseDTO departmentResponseDTO = service.create(departmentRequestDTO);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(departmentResponseDTO.id()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody DepartmentRequestDTO departmentRequestDTO, @PathVariable Long id) {
        try {
            service.update(departmentRequestDTO, id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
