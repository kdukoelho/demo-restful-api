package com.rabbit.demorestfulapi.service;

import com.rabbit.demorestfulapi.dto.EmployeeRequestDTO;
import com.rabbit.demorestfulapi.dto.EmployeeResponseDTO;
import com.rabbit.demorestfulapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rabbit.demorestfulapi.entities.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    public List<EmployeeResponseDTO> findAll(){
        List<EmployeeResponseDTO> employeeList = new ArrayList<>();
        this.repository.findAll().forEach(employee -> employeeList.add(new EmployeeResponseDTO(employee)));
        return employeeList;
    }

    public EmployeeResponseDTO findById(Long id){
        Optional<Employee> employee = repository.findById(id);
        return new EmployeeResponseDTO(
                employee.orElseThrow(RuntimeException::new));
    }

    @Transactional
    public EmployeeResponseDTO create(EmployeeRequestDTO employeeRequestDTO){
        Employee employee = new Employee(employeeRequestDTO);
        this.repository.save(employee);
        return new EmployeeResponseDTO(employee);
    }

    @Transactional
    public EmployeeResponseDTO update(EmployeeRequestDTO employeeRequestDTO, Long id){
        Employee employee = new Employee(employeeRequestDTO);
        employee.setId(id);
        this.repository.save(employee);
        return new EmployeeResponseDTO(employee);
    }

    @Transactional
    public String deleteById(Long id){
        this.repository.deleteById(id);
        return "deleted";
    }
}
