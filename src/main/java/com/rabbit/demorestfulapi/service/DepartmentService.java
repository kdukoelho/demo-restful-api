package com.rabbit.demorestfulapi.service;

import com.rabbit.demorestfulapi.dto.DepartmentRequestDTO;
import com.rabbit.demorestfulapi.dto.DepartmentResponseDTO;
import com.rabbit.demorestfulapi.entities.Department;
import com.rabbit.demorestfulapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository repository;

    public List<DepartmentResponseDTO> findAll(){
        List<DepartmentResponseDTO> departmentResponseDTOList = new ArrayList<>();
        this.repository.findAll().forEach(department -> departmentResponseDTOList.add(new DepartmentResponseDTO(department)));
        return departmentResponseDTOList;
    }

    public DepartmentResponseDTO findById(Long id){
        Optional<Department> department = repository.findById(id);
        return new DepartmentResponseDTO(
                department.orElseThrow(RuntimeException::new));
    }

    @Transactional
    public DepartmentResponseDTO create(DepartmentRequestDTO departmentRequestDTO){
        Department department = new Department(departmentRequestDTO);
        this.repository.save(department);
        return new DepartmentResponseDTO(department);
    }

    @Transactional
    public DepartmentResponseDTO update(DepartmentRequestDTO departmentRequestDTO, Long id){
        Department department = new Department(departmentRequestDTO);
        department.setId(id);
        this.repository.save(department);
        return new DepartmentResponseDTO(department);
    }

    @Transactional
    public String deleteById(Long id){
        this.repository.deleteById(id);
        return "deleted";
    }
}
